/**
*   Menu.js
*	메뉴 데이터를 로드하고 처리하는 스크립트
*/
var menuRows;
var topMenu = [];
var sideMenu = [];
var selectedMenu;

// 1뎁스, 2뎁스 메뉴명 찾기
var findTopMenuTextsByProgmId = function(targetProgmId) {
	try {
		var matchingDepth2Item = topMenu.find(item => item.progmId === targetProgmId);
		
		if (!matchingDepth2Item) {
			console.warn('No match found for progmId:', targetProgmId);
			return;
		}
		
		var parentSystmKb = matchingDepth2Item.systmKb;
		var matchingDepth1Item = topMenu.find(item => item.progmId === parentSystmKb);
		
		if (!matchingDepth1Item) {
			console.warn('No match found for systmKb:', parentSystmKb);
			return;
		}
		
		var depth1Text = matchingDepth1Item.text;
		var depth2Text = matchingDepth2Item.text;
		
		return [depth1Text, depth2Text];
	} catch (e) {
		console.error('Error in findTopMenuTextsByProgmId:', e);
		return null;
	}
};

var updateTopMenuTexts = (targetProgmId) => {
	const result = findTopMenuTextsByProgmId(targetProgmId);
	if (result) {
		const [depth1Text, depth2Text] = result;
		const spanElements = document.querySelectorAll('.dpt2 span');
		
		if (spanElements[0] && depth1Text) {
			spanElements[0].textContent = depth1Text;
		}
		
		if (spanElements[1] && depth2Text) {
			spanElements[1].textContent = depth2Text;
		}
	}
};

var setSelectedMenu = (progmId) => {
	selectedMenu = findMenuByProgmId(sideMenu, progmId);
	var matchedSideMenu = findMatchedSideMenu(sideMenu, progmId);

	if (matchedSideMenu) {
		var menuPath = buildMenuPath(selectedMenu, matchedSideMenu);
		selectedMenu.menuPath = menuPath;
		
		// 즉시 실행 함수를 사용하여 HTML 요소에 메뉴 경로를 반영합니다.
		(function (path) {
			$('.menuPath-wrap .menuPath-title').text(path);
		})(menuPath);
	}
};

var findMenuByProgmId = (menuList, progmId) => menuList.find((menu) => menu.progmId === progmId);

var findMatchedSideMenu = (sideMenu, progmId) => {
	var prefixToMatch = progmId.substring(0, 3);
	return sideMenu.find((menu) => menu.progmId && menu.progmId.startsWith(prefixToMatch));
};

var buildMenuPath = (selectedMenu, matchedSideMenu) => {
	var menuPath = matchedSideMenu.text + ' > ' + selectedMenu.text;
	
	var addPrefixText = (menuList, key) => {
		var matchedMenu = findMenuByProgmId(menuList, selectedMenu[key]);
		if (matchedMenu) {
			menuPath = matchedMenu.text + ' > ' + menuPath;
		}
	};

	addPrefixText(topMenu, 'upmuuKb');
	addPrefixText(topMenu, 'systmKb');

	return menuPath;
};

var loadContent = (url, progmId) => {
	// 진행 중인 exios 요청이 있다면 알림 표시 후 함수 종료
	if (exios.cancelTokens.length > 0) {
		korbiztech.alert('MSG_PENDING_REQUESTS');
		console.warn("Pending requests are still running. Please wait...");
		return;
	}
	// 같은 URL로의 중복 이동인지 확인
	if (myRouter.isDuplicateNavigation(url)) return;
	// 기존에 등록된 이벤트 핸들러와 데이터를 삭제
	$('#content .con_wrap').off().empty();
	// viewX 초기화
	resetViewX();
	// 콘텐츠 로드
	exios.get(url).then((response) => {
		$('#content .con_wrap').html(response.data);
		setSelectedMenu(progmId);
	}).catch((error) => {
		console.error('Something went wrong:', error);
	});
};

// 사이드 메뉴 아이템 생성 함수
var createSideMenuItem = function(item, parentId, order) {
	var menuItem = {
		'id': (sideMenu.length + 1).toString(),
		'pid': parentId,
		'order': order.toString(),
		'text': item.PROGM_NM,
		'progmId': item.PROGM_ID,
		'systmKb': item.SYSTM_KB,
		'upmuuKb': item.UPMUU_KB
	};

	if (item.PROGM_LV === "3") {
		var url = item.SYSTM_KB + '/' + item.UPMUU_KB + '/' + item.PROGM_ID || '';
		menuItem.link = 'javascript:loadContent(\'' + url + '\', \'' + item.PROGM_ID + '\', setSelectedMenu);';
	}

	return menuItem;
};

// 지정된 레벨의 메뉴 아이템 처리 함수
var processMenuItem = function(level, progmId, parentIdFinder) {
	$.each(menuRows, function(i, item) {
		var itemLevel = parseInt(item.PROGM_LV, 10);
		if (itemLevel === level && item.UPMUU_KB === progmId) {
			var parentId = parentIdFinder(item);
			var menuItem = createSideMenuItem(item, parentId, sideMenu.length + 1);
			sideMenu.push(menuItem);
		}
	});
};

// 사이드 메뉴 로드 함수
var loadSideMenu = function(progmId) {
	sideMenu = [];
	processMenuItem(2, progmId, function() { return progmId; });
	processMenuItem(3, progmId, function(item) {
		var parent3rdLevelItem = sideMenu.find(third => item.PROGM_ID.startsWith(third.progmId));
		return parent3rdLevelItem ? parent3rdLevelItem.id : null;
	});
	
	updateTopMenuTexts(progmId);
	SBUxMethod.refresh('side_json');
	
	// sideMenu 표출
	const mainElement = document.querySelector('.main.dsb');
	if (mainElement) {
		mainElement.classList.remove('dsb');
	}
};

// 메뉴 데이터 처리 함수
var processMenuData = function(menuRows) {
	var secondLevelCounts = {};

	$.each(menuRows, function(i, item) {
		var level = parseInt(item.PROGM_LV, 10);
		var id = (topMenu.length + 1).toString();

		// 최상위 레벨 메뉴 처리
		if (level === 0) {
			var menuItem = {
				'id': id,
				'pid': '0',
				'order': id,
				'text': item.PROGM_NM,
				'progmId': item.PROGM_ID,
				'systmKb': item.SYSTM_KB,
				'upmuuKb': item.UPMUU_KB
			};
			topMenu.push(menuItem);
		}

		// 두 번째 레벨 메뉴 처리
		if (level === 1) {
			var parentItem = topMenu.find(parent => parent.systmKb === item.SYSTM_KB);
			if (typeof parentItem !== 'undefined') {
				secondLevelCounts[parentItem.id] = (secondLevelCounts[parentItem.id] || 0) + 1;
				var secondLevelId = parentItem.id + '_' + secondLevelCounts[parentItem.id];
				var secondLevelOrder = secondLevelCounts[parentItem.id].toString();

				var secondMenuItem = {
					'id': secondLevelId,
					'pid': parentItem.id,
					'order': secondLevelOrder,
					'text': item.PROGM_NM,
					'link': 'javascript:loadSideMenu(\''+item.PROGM_ID+'\');',
					'progmId': item.PROGM_ID,
					'systmKb': item.SYSTM_KB,
					'upmuuKb': item.UPMUU_KB
				};
				topMenu.push(secondMenuItem);
			}
		}
	});

	return {
		topMenu: topMenu,
		sideMenu: sideMenu
	};
};

$(function() {
	exios.get('/api/COM/menu').then((response) => {
		const fetchedMenuData = response.data;
		const menuStructure = processMenuData(fetchedMenuData);
		menuRows = fetchedMenuData;
		topMenu = menuStructure.topMenu;
		sideMenu = menuStructure.sideMenu;
		SBUxMethod.refresh('menu_json');
		SBUxMethod.refresh('side_json');
	}).catch((e) => {
		console.error('Could not load menu list. Please check the database connection');
		console.error(e.responseText);
	});
});