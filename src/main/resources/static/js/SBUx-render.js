/**
* 	SBUx-render.js
*	변화 감지 javascirpt
*/
var observeContentChange = function(callback) {
	// #content 요소 선택
	var contentElement = document.querySelector('#content');

	// 변화를 감지할 옵션 설정
	var config = { childList: true, subtree: true };

	var checkNodes = function(nodes, callback) {
		nodes.forEach(function(node) {
			if (node.tagName && node.tagName.toLowerCase().startsWith('sbux-')) {
				callback();
			}
			if (node.childNodes && node.childNodes.length > 0) {
				checkNodes(node.childNodes, callback);
			}
		});
	};

	// 변화를 감지하는 Observer 생성
	var observer = new MutationObserver(function(mutations) {
		mutations.forEach(function(mutation) {
			if (mutation.type === 'childList' && mutation.addedNodes.length > 0) {
				checkNodes(mutation.addedNodes, callback);
			}
		});
	});

	// #content 요소에 Observer 적용
	observer.observe(contentElement, config);
};

var contentChanged = function() {
	SBUxMethod.render();
	console.log('SBUx render complete');
	$(function(){
		SBUxMethod.connectAllGridToComps();
		console.log('SBUx connectAllGridToComps complete');
	});
};

$(function(){
	console.log('dom ready');
	// contentChanged 함수를 콜백으로 전달하여 변화 감지 시작
	observeContentChange(contentChanged);
	console.log('Starting to observe changes in #content area for "sbux-" prefixed tags.');
});
