/**
* 	korbiztech.js
*	공통 처리 javascirpt
*/
const GRID_STATUS = {
	NORMAL: 0,
	INSERT: 1,
	UPDATE: 2,
	INSERT_UPDATE: 3,
	DELETE: 4,
	ENTER_KEY: 13
}

var korbiztech = (function() {
	var messageModule = {
		MSG_GRID_GET_SUCCESS: '데이터 조회가 성공적으로 완료되었습니다.',
		MSG_GRID_SAVE_SUCCESS: '데이터 저장이 성공적으로 완료되었습니다.',
		MSG_GRID_GET_FAIL: '데이터 조회 중 오류가 발생했습니다.',
		MSG_GRID_SAVE_FAIL: '데이터 저장 중 오류가 발생했습니다.',
		MSG_GRID_NO_CHANGES: '변경된 내용이 없습니다.',
		MSG_GRID_PK_NOT_DEFINED: '키가 정의되지 않았습니다.',
		MSG_GRID_KEY_DUPLICATE: '키 값이 중복되었습니다.',
		MSG_GRID_ENTER_CELL_VALUE: '셀 값을 입력해 주세요.',
		MSG_GRID_EDIT_MODE_ONLY: '편집모드에서만 이 기능을 사용할 수 있습니다.',
		MSG_GRID_VIEW_MODE_ONLY: '편집모드에서는 이 기능을 사용할 수 없습니다.',
		MSG_GRID_ROWS_ADDED: "{1}건이 추가 되었습니다.",
		MSG_FILE_UPLOAD_SUCCESS: '파일이 업로드 되었습니다.',
		MSG_FILE_UPLOAD_FAIL: '파일 업로드 중 오류가 발생했습니다.',
		MSG_FILE_PARTIAL_UPLOAD_SUCCESS: '{1} 건을 제외한 {2} 건이 업로드 되었습니다.',
		MSG_FILE_INVALID_EXTENSION: '확장자가 {1}인 파일만 업로드 가능합니다.',
		MSG_GRID_ROWS_DISTINCT_ADDED: '중복된 {1}건을 제외한 {2}건이 추가되었습니다.',
		MSG_NOT_SELECTED: "{1}을(를) 선택 해 주세요.",
		MSG_NOT_ENTERED: "{1}을(를) 입력 해 주세요.",
		MSG_NOT_EQUAL: "{1}과(와) {2}이(가) 일치하지 않습니다.",
		MSG_UNKNOWN_KEY: '알 수 없는 메시지 키:',
		MSG_PENDING_REQUESTS: '종료되지 않은 요청이 있습니다. 잠시 후 다시 시도해 주세요.'
	};

	var alertModule = function(messageKey, ...params) {
		var message = messageModule[messageKey];
		if (message) {
			params.forEach((param, index) => {
				const placeholder = `{${index + 1}}`;
				message = message.replace(placeholder, param);
			});
			var properties = {
				title: message,
				time: 1300,
				fade_in_speed : 200,
				fade_out_speed : 200,
				show_close_on_footer: false
			}
			SBUxMethod.openAlert(properties);
		} else {
			console.error(messageModule.MSG_UNKNOWN_KEY, messageKey);
		}
	};

	var gridModule = {
		getGrid: (gridIdWithViewX) => {
			const keys = gridIdWithViewX.split('.');
			return keys.reduce((obj, key) => obj[key], window);
		},
		getPureGridId: (gridIdWithViewX) => {
			const keys = gridIdWithViewX.split('.');
			return keys.length > 1 ? keys[1] : keys[0];
		},
		initializeProperties: (properties) => {
			// 기본 properties 설정
			if (!properties.emptyrecords) {
				properties.emptyrecords = '데이터가 존재하지 않습니다.';
			}
			if (properties.custompanel && properties.custompanel.includes('refresh')) {
				properties.saveorgdata = true;
			}
			if (properties.controlpanel) {
				delete properties.controlpanel;
			}
			if (properties.rowheaderupdatecallback === undefined) {
				properties.rowheaderupdatecallback = function() {};
			}
			if (properties.tooltip === undefined) {
				properties.tooltip = true;
			}
			if (properties.selectmode === undefined) {
				properties.selectmode = 'free';
			}
			if (properties.allowcopy === undefined) {
				properties.allowcopy = true;
			}
			if (properties.allowpaste === undefined) {
				properties.allowpaste = true;
			}
			if (properties.pasteaddrow === undefined) {
				properties.pasteaddrow = true;
			}
			if (properties.updatepastestatus === undefined) {
				properties.updatepastestatus = true;
			}
		},
		handleCustomPanel: (properties) => {
			// custompanel 값이 있고, 배열인 경우에만 처리
			if (Array.isArray(properties.custompanel)) {
				properties.controlpanel = properties.controlpanel || {};
				properties.controlpanel.customs = properties.controlpanel.customs || [];

				// parentid 값을 id로 가지는 DOM 요소에 class 추가
				if (typeof properties.parentid === 'string') {
					const targetElement = document.getElementById(properties.parentid);
					if (targetElement) {
						targetElement.classList.add('cocs-table-list');
					}
				}

				// 빈 문자열이나 null, undefined를 제거하고 유효한 action만 처리, 순서 정렬
				const sortOrder = ['toggleEditMode', 'add', 'delete', 'refresh', 'exportExcel', 'importExcel', 'template', 'save'];
				properties.custompanel = properties.custompanel
					.filter(action => action && action.trim() !== '')
					.sort((a, b) => sortOrder.indexOf(a) - sortOrder.indexOf(b));

				if (properties.custompanel.length > 0) {
					properties.custompanel.forEach((action) => {
						switch (action) {
							case 'toggleEditMode':
								properties.controlpanel.customs.push({
									method: `korbiztech.gridAction.toggleEditMode('${properties.id}')`,
									callback: function() {}
								});
								break;
							case 'refresh':
								properties.controlpanel.customs.push({
									method: `korbiztech.gridAction.refresh('${properties.id}')`,
									callback: function() {}
								});
								break;
							case 'add':
								properties.controlpanel.customs.push({
									method: `korbiztech.gridAction.add('${properties.id}')`,
									callback: function() {}
								});
								break;
							case 'delete':
								properties.controlpanel.customs.push({
									method: `korbiztech.gridAction.del('${properties.id}')`,
									callback: function() {}
								});
								break;
							case 'save':
								properties.controlpanel.customs.push({
									method: `korbiztech.gridAction.save('${properties.id}')`,
									callback: function() {}
								});
								break;
							case 'template':
								properties.controlpanel.customs.push({
									method: `korbiztech.gridAction.template('${properties.id}')`,
									callback: function() {}
								});
								break;
							case 'exportExcel':
								properties.controlpanel.customs.push({
									method: `korbiztech.gridAction.exportExcel('${properties.id}')`,
									callback: function() {}
								});
								break;
							case 'importExcel':
								properties.controlpanel.customs.push({
									method: `korbiztech.gridAction.importExcel('${properties.id}')`,
									callback: function() {}
								});
								break;
							default:
								console.log('알 수 없는 동작:', action);
						}
					});
				}
			} else {
				console.log('custompanel이 배열 형태가 아닙니다.');
			}
		},
		createGrid: function(properties) {
			this.initializeProperties(properties);
			this.handleCustomPanel(properties);

			var primaryKeys = properties.primarykey || [];
			properties.columns.forEach(function(column) {
				// primarykey style 처리
				if (primaryKeys.includes(column.ref)) {
					column.style += ';font-weight:bold;background-color:#EFEFEF;color:#999';
				}
				// checkbox status문제 해결
				if (column.type === 'checkbox' && column.ref === 'check') {
					column.typeinfo = {
						fixedcellcheckbox: { usemode: true },
						ignoreupdate: true
					};
				}
			});
			
			// 이전 상태를 저장
			const prevColumns = JSON.parse(JSON.stringify(properties.columns));
			let isValid = true;
			
			// viewWidth 값에 따른 column width 재정의
			const viewWidth = properties.viewWidth;
			const MIN_COLUMN_WIDTH = 30;
			
			if (viewWidth && typeof viewWidth === 'string' && viewWidth.endsWith('px')) {
				// viewWidth가 'px'로 끝나면
				let viewWidthPx = parseInt(viewWidth, 10);
				let totalFixedWidthPx = 0;
				let totalPercentage = 0;
				
				properties.columns.forEach((column) => {
					if (typeof column.width === 'string' && column.width.endsWith('px')) {
						// width가 'px'로 끝나는 경우 합계에 추가
						totalFixedWidthPx += parseInt(column.width, 10);
					} else if (typeof column.width === 'string' && column.width.endsWith('%')) {
						// width가 '%'로 끝나는 경우 합계에 추가
						totalPercentage += parseInt(column.width, 10);
					}
				});
				
				if (totalFixedWidthPx > viewWidthPx || totalPercentage > 100) {
					// totalFixedWidthPx가 viewWidthPx를 초과하거나 totalPercentage가 100을 초과하면 리턴
					console.warn('Cannot proceed due to exceeding widths or percentages.');
					isValid = false;
				}
				
				let remainingWidthPx = viewWidthPx - totalFixedWidthPx;
				
				properties.columns.forEach((column) => {
					if (typeof column.width === 'string' && column.width.endsWith('%')) {
						const percentage = parseInt(column.width, 10);
						const pixelWidth = Math.floor((remainingWidthPx * percentage) / 100);
						
						// 계산된 픽셀 크기가 최소 크기보다 작으면 리턴
						if (pixelWidth < MIN_COLUMN_WIDTH) {
							console.warn('Calculated column width is too small. Please adjust the layout.');
							isValid = false;
						}
						column.width = `${pixelWidth}px`;
					}
				});
				
				if (!isValid) {
					// 유효하지 않으면 이전 상태로 되돌림
					properties.columns = prevColumns;
				}
			}
			
			// grid 생성
			var grid = _SBGrid.create(properties);
			properties.custompanel && this.attachCustomPanelIcons(properties, grid);
			grid.primarykey = properties.primarykey;
			grid.total = properties.total;
			grid.isEditMode = properties.total ? false : true;
			if (!grid.isEditMode) {
				korbiztech.gridAction.setColDisabled(grid);
			}
			return grid;
		},
		attachCustomPanelIcons: function(properties) {
			// parentid 값을 id로 가지는 DOM 요소 찾기
			const parentElement = document.getElementById(properties.parentid);
			if (parentElement) {
				// parentElement 내에서 .sbgrid_CPI 클래스를 가진 모든 요소 찾기
				const targetElements = parentElement.querySelectorAll('.sbgrid_CPI');
				targetElements.forEach((targetElement) => targetElement.removeAttribute('style'));
				
				targetElements.forEach((targetElement) => {
					const wrapperDiv = document.createElement('div');
					wrapperDiv.className = 'edit_grid';
					const editboxDiv = document.createElement('div');
					editboxDiv.className = 'editbox';
					const loadboxDiv = document.createElement('div');
					loadboxDiv.className = 'loadbox';
					// edit_grid 안에 editbox와 loadbox를 추가합니다.
					wrapperDiv.appendChild(editboxDiv);
					wrapperDiv.appendChild(loadboxDiv);
					
					// 원래 있던 자식들을 wrapperDiv로 옮깁니다.
					while (targetElement.firstChild) {
						wrapperDiv.appendChild(targetElement.firstChild);
					}
					
					// wrapperDiv를 원래의 위치에 추가합니다.
					targetElement.appendChild(wrapperDiv);
				});
			};
			
			properties.custompanel.forEach(function(action, index) {
				var customClass = 'sbgrid_CPA_customs_' + (index + 1) + '_st';
				var targetIcon = $('#' + properties.parentid + ' i[class="sbgrid_CPA_customs sbgrid_CPA_customs_st ' + customClass + '"]');
				targetIcon.attr('data-action', action);
				
				if (action === 'importExcel') {
					var uniqueId = "importExcel_file_" + korbiztech.grid.getPureGridId(properties.id);
					var uniqueFormId = "loadExcelForm_" + korbiztech.grid.getPureGridId(properties.id);
					var hiddenInput = $('<input id="' + uniqueId + '" name="excel" type="file" style="display:none;" accept=".xlsx">');
					hiddenInput.attr('data-gridId', properties.id);
					hiddenInput.on('change', function() {
						korbiztech.file.uploadExcel(uniqueFormId, uniqueId);
					});
					hiddenInput.wrap('<form id="' + uniqueFormId + '"></form>');
					targetIcon.append(hiddenInput.parent());
				}
			});
			
			// i 태그를 이동
			const loadbox = $(parentElement).find('.loadbox');
			const editbox = $(parentElement).find('.editbox');
			const allIcons = $(parentElement).find('i[data-action]');
			
			allIcons.each(function() {
				const action = $(this).attr('data-action');
				const currentIcon = $(this);
				currentIcon.hide();
				
				switch (action) {
					case 'toggleEditMode':
						const toggleEditSpan = $('<span class="toggle_edit"></span>');
						const checkbox = $('<input type="checkbox" id="edit_onoff" name="">');
						const label = $('<label for="edit_onoff">편집 <span></span></label>');
						checkbox.click(() => currentIcon.click());
						toggleEditSpan.append(checkbox);
						toggleEditSpan.append(label);
						editbox.append(toggleEditSpan);
						break;
					case 'add':
					case 'delete':
					case 'refresh':
					case 'save':
					case 'template':
					case 'exportExcel':
					case 'importExcel':
						const buttonElement = $('<button></button>');
						buttonElement.click(() => currentIcon.click());
						buttonElement.addClass(`${action} grid_btn`);
						buttonElement.text(
							action === 'add' ? '행 추가' :
							action === 'delete' ? '행 삭제' :
							action === 'refresh' ? '초기화' :
							action === 'save' ? '저장하기' :
							action === 'template' ? '템플릿 다운로드' :
							action === 'exportExcel' ? '엑셀 다운로드' :
							action === 'importExcel' ? '엑셀 업로드' : ''
						);
						if (['add', 'delete', 'refresh'].includes(action)) {
							editbox.append(buttonElement);
						} else {
							loadbox.append(buttonElement);
						}
						break;	
				}
			});
		}
	};

	var tabActionModule = {
		getActiveTabValue: function() {
			var activeTabElement = document.querySelector('li.sbux-tabs-item.active');
			var tabValue;
	
			if (activeTabElement) {
				tabValue = activeTabElement.getAttribute('data-sbux-id');
				return tabValue.toLowerCase();
			} else {
				return null;
			}
		}
	};

	var gridActionModule = {
		checkSingleKey: function(checkData, dataVar, datagridVar, keyName) {
			for (var i = 0; i < checkData.length; i++) {
				var col = -1;
				if (checkData[i].data[keyName] === '') {
					korbiztech.alert('MSG_GRID_ENTER_CELL_VALUE');
					col = viewX[datagridVar].getColRef(keyName);
				} else {
					var occurrenceCount = 0;
					for (var j = 0; j < viewX[dataVar].length; j++) {
						if (checkData[i].data[keyName] === viewX[dataVar][j][keyName]) {
							occurrenceCount++;
							if (occurrenceCount > 1) {
								korbiztech.alert('MSG_GRID_KEY_DUPLICATE');
								col = viewX[datagridVar].getColRef(keyName);
								break;
							}
						}
					}
				}
				if (col != -1) {
					viewX[datagridVar].setRow(checkData[i].rownum);
					viewX[datagridVar].setCol(col);
					viewX[datagridVar].editCell();
					return false;
				}
			}
			return true;
		},
		checkCompositeKey: function(checkData, dataVar, datagridVar, primarykey) {
			for (var i = 0; i < checkData.length; i++) {
				for (var k = 0; k < primarykey.length; k++) {
					var keyName = primarykey[k];
					var col = -1;
		
					if (checkData[i].data[keyName] === '') {
						korbiztech.alert('MSG_GRID_ENTER_CELL_VALUE');
						col = viewX[datagridVar].getColRef(keyName);
					}
		
					var duplicateCount = 0;
					for (var j = 0; j < viewX[dataVar].length; j++) {
						if (checkData[i].data[keyName] === viewX[dataVar][j][keyName]) {
							duplicateCount++;
							if (duplicateCount > 1) {
								korbiztech.alert('MSG_GRID_KEY_DUPLICATE');
								col = viewX[datagridVar].getColRef(keyName);
								break;
							}
						}
					}
		
					if (col != -1) {
						viewX[datagridVar].setRow(checkData[i].rownum);
						viewX[datagridVar].setCol(col);
						viewX[datagridVar].editCell();
						return false;
					}
				}
			}
			return true;
		},
		disablePrimaryKeyCells: function(dataGridVar) {
			var fixedRows = viewX[dataGridVar].getFixedRows();
			var totalRows = viewX[dataGridVar].getRows();
			var primarykey = viewX[dataGridVar].primarykey;
			
			if (Array.isArray(primarykey) && primarykey.length > 0) {
				for (var k = 0; k < primarykey.length; k++) {
					var keyName = primarykey[k];
					var col = viewX[dataGridVar].getColRef(keyName);
					viewX[dataGridVar].setCellDisabled(fixedRows, col, totalRows - 1, col, true, false, false);
					viewX[dataGridVar].refresh({'focus': false});
				}
			}
		},
		refresh: function(gridId) {
			var grid = gridModule.getGrid(gridId);
			if (grid.isEditMode) {
				grid.setOrgGridDataAll();
				if (grid && grid.gridStatus) {
					grid.gridStatus = undefined;
				}
			} else {
				korbiztech.alert('MSG_GRID_EDIT_MODE_ONLY');
			}
		},
		add: function(gridId) {
			var grid = gridModule.getGrid(gridId);
			if (grid.isEditMode) {
				var primaryKeys = grid.primarykey;
				if (grid) {
					grid.addRow(true, '', true);
					if (Array.isArray(primaryKeys) && primaryKeys.length > 0) {
						var row = grid.getRow();
						primaryKeys.forEach(function(key, index) {
							var col = grid.getColRef(key);
							grid.setCellDisabled(row, col, row, col, false, true);
							if (index === 0) {
								grid.setRow(row);
								grid.setCol(col);
								grid.editCell();
							}
						});
					}
				} else {
					console.error('해당 이름의 grid가 정의되지 않았습니다.');
				}
			} else {
				korbiztech.alert('MSG_GRID_EDIT_MODE_ONLY');
			}
		},
		del: function(gridId) {
			var grid = gridModule.getGrid(gridId);
			if (grid.isEditMode) {
				var col = grid.getColRef('check');
				var checkedRows = grid.getCheckedRows(col);
				
				for (var index = checkedRows.length - 1; index >= 0; index--) {
					var row = checkedRows[index];
					var status = grid.getRowStatus(row);
					if (status == GRID_STATUS.INSERT || status == GRID_STATUS.INSERT_UPDATE) {
						grid.deleteRow(row);
					} else if (status == GRID_STATUS.NORMAL || status == GRID_STATUS.UPDATE) {
						grid.setRowStatus(row, GRID_STATUS.DELETE);
					}
				}
				grid.setFixedcellcheckboxChecked(0, grid.getColRef('check'), false);
			} else {
				korbiztech.alert('MSG_GRID_EDIT_MODE_ONLY');
			}
		},
		save: function(gridId) {
			var grid = gridModule.getGrid(gridId);
			if (grid.isEditMode) {
				var tabValue = korbiztech.tabAction.getActiveTabValue();
				if (tabValue) {
					viewX.saveGridData(tabValue);
				} else {
					viewX.saveGridData(gridId);
				}
			} else {
				korbiztech.alert('MSG_GRID_EDIT_MODE_ONLY');
			}
		},
		toggleEditMode: function(gridId) {
			var grid = gridModule.getGrid(gridId);
			var total = grid ? grid.total : null;
			
			// total이 존재하지 않는 경우, 아무 동작도 하지 않습니다.
			if (!total) return;

			if (grid.isEditMode) {
				// total이 존재하고 isEditMode가 true인 경우
				grid.gridStatus = grid.getUpdateData(true, 'all');
				grid.clearStatus();
				grid.setTotal(grid.total);
				korbiztech.gridAction.setColDisabled(grid);
			} else {
				// total이 존재하고 isEditMode가 false인 경우
				grid.clearTotal();
				if (grid && grid.gridStatus) {
					grid.gridStatus.forEach(function (item) {
						grid.addStatus(item.rownum, item.status);
					});
				}
				korbiztech.gridAction.setColEnabled(grid);
			}
			// isEditMode의 값을 반전시킵니다.
			grid.isEditMode = !grid.isEditMode;
		},
		setColState: function(grid, isDisabled) {
			return new Promise(function(resolve) {
				grid.lockGrid(true);
				var totalColumns = grid.getCols();
				for (var i = 0; i < totalColumns; i++) {
					grid.setColDisabled(i, isDisabled);
				}
				grid.refresh({'focus': false});
				grid.lockGrid(false);
				resolve();
			});
		},
		setColDisabled: function(grid) {
			return this.setColState(grid, false);
		},
		setColEnabled: function(grid) {
			return this.setColState(grid, false);
		},
		template: function(gridId) {
			var grid = gridModule.getGrid(gridId);
			grid.exportLocalExcel('excel', {
				bSaveLabelData: true,
				bNullToBlank: true,
				bSaveSubtotalValue: true,
				bCaptionConvertBr: true,
				arrSaveConvertText: true
			});
		},
		exportExcel: function(gridId) {
			var grid = gridModule.getGrid(gridId);
			var rowHeader = grid.getRowHeader();
			var arrRemoveCols = Array.from({ length: rowHeader.length }, (_, i) => i + 1);
			grid.exportData('xlsx', 'excel', true, { arrRemoveCols, combolabel: true });
		},
		importExcel: function(gridId) {
			var hiddenInput = document.getElementById('importExcel_file_' + korbiztech.grid.getPureGridId(gridId));
			hiddenInput.click();
		}
	};

	var parseModule = {
		addPropertiesToData: function(originData, addData) {
			var originData = JSON.parse(originData);
			
			if (typeof addData !== 'object' || addData === null) {
				console.error('addData must be an object.');
				return;
			}
			
			if (Array.isArray(originData) === false) {
				// originData가 배열이 아닌 경우 배열로 만들기
				originData = [originData];
			}
			
			var result = originData.map(function(item) {
				for (var key in addData) {
					item.data[key] = addData[key];
				}
				return item;
			});
			return JSON.stringify(result);
		}
	};
	
	var fileModule = {
		validateFileData: function(fileData) {
			if (fileData === null) {
				korbiztech.alert('MSG_NOT_SELECTED', '파일');
				return false;
			}
			return true;
		},
		filterFiles: function(fileData) {
			const filteredFiles = fileData ? fileData.filter(file => !file.error) : [];
			const errorFiles = fileData ? fileData.filter(file => file.error) : [];
			return { filteredFiles, errorFiles };
		},
		uploadFiles: function(url, data) {
			return new Promise((resolve, reject) => {
				$.ajax({
					url: url,
					type: 'POST',
					data: data,
					processData: false,
					contentType: false,
					success: resolve,
					error: reject
				});
			});
		},
		uploadExcel: function(uniqueFormId, uniqueId) {
			const inputElement = document.getElementById(uniqueId);
			const gridId = inputElement.getAttribute('data-gridId');
			const inputFile = document.querySelector('input[data-gridId="' + gridId + '"]');
			const selectedFile = inputFile.files[0];
			
			if (selectedFile) {
				const fileName = selectedFile.name;
				const fileExtension = fileName.split('.').pop().toLowerCase();
				if (fileExtension === 'xlsx') {
					const objLoadExcel = {
						formid: uniqueFormId,
						action: '/api/COM/excel',
						fileinputid: uniqueId
					}
					const pureGridId = korbiztech.grid.getPureGridId(gridId);
					viewX[pureGridId].importExcel(objLoadExcel);
					inputFile.value = '';
				} else {
					korbiztech.alert('MSG_FILE_INVALID_EXTENSION', 'xlsx');
					inputFile.value = '';
				}
			} else {
				inputFile.value = '';
			}
		}
	};
	
	return {
		message: messageModule,
		alert: alertModule,
		grid: gridModule,
		tabAction: tabActionModule,
		gridAction: gridActionModule,
		parse: parseModule,
		file: fileModule
	};
})();
