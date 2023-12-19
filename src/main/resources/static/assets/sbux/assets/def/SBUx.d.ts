declare namespace SBUxMethod {
    function set(modelName: string, value: string, option?:any): void;
    function setText(modelName, value, options?): void;
    function setValue(modelName, value, options?): void;
    function setIndex(modelName, value, options?): void;
    function setExt(selector, compAttr, data): void;


    function get(modelName: string): any;
    function getText(modelName: string): any;
    function getValue(modelName: string): any;
    function getInstanceEvent(modelName: string): any;
    function getExt(selector, compAttr): any;
    function getAttrExt(selector, compAttr): any;

    function clear(modelName: string): void;
    function attr(modelName: string, attrName: string, attrValue: string|boolean): void;
    function getAttr(modelName: string): any;
    function focus(modelName: string): void;

    function setLocalStorage(key, data): void;
    function getLocalStorage(key): any;

    function getSysLog(): any;
    function getLog(): any;

    function eventCall(modelName: string, attrName: string): void;

    function changeLocale(locale: string): void;
    function changeLocaleWithFile(localeName: string, fileUrl?: string, applyAll?: boolean): void;
    function changeLocaleWithJson(localeName: string, jsonData: string, applyAll?: boolean): void;

    function dataBind(jsonData, option): void;

    function getAllData(returnType?: string, omit?: boolean, compType?: string): void;
    function getSubscribeData(dtmodelName, reJsonOrOption?: any, isCompact?: boolean, componentType?: string): any;

    function clearAllData(compType?: string): void;
    function clearSubscribeData(dtmodelName, compTypeOrOptions?: any): any;

    function getComponents(): any;
    function clearStructure(option?: any): void;

    function exportImage(fileName, selector?): void;
    function exportBinaryImage(funcName, selector?): void;
    function exportImageData(funcName, selector?): void;
    function exportPdf(fileName, selector?): void;

    function getNamespaceData(namespaceId: string): any;
    function clearNamespaceData(namespaceId: string): any;
    function refreshNamespaceData(namespaceId: string, setting?): any;

    function changeGroupAttr(groupId: string, attrName: string, attrValue: string|boolean): void;
    function showGroup(groupId: string): void;
    function hideGroup(groupId: string): void;
    function getGroupData(groupId: string, returnType?: string, omit?: boolean, compType?: string): any;
    function clearGroupData(groupId: string, compType?: string): void;


    function calcHistogram(jsonData: object, column: string, textJson: object): any;
    function calcAxisData(jsonData: object, axisX: string, axisY: string): any;
    function calcStackData(options: object): any;

    function getGridCompsData(gridIdOrOptions: any, returnJsonType?: string, isCompact?: boolean, searchType?: string): any;
    function clearGridCompsData(gridIdOrOptions: any, searchType?: string): void;
    function sendCompsDataToGrid(gridIdOrOptions: any): void;
    function disConnectCompToGrid(modelName: string): void;
    function initGridConnection(gridId: string, options?: any): void;
    function connectGridToComps(gridId: string, options?: any): void;
    function connectAllGridToComps(gridId?: string, options?: any): void;

    function setGridRowDataToComps(gridId: string, rowJsonData: any): void;
    function setGridCellDataToComp(gridId, gridRefName, value, options?): void;


    function show(modelName: string): void;
    function hide(modelName: string): void;
    function isHide(modelName: string): boolean;
    function refresh(modelName: string, attributes?:any): void;
    function secondRefresh(modelName): void;

    function refreshAll(attributes?: any): void;

    function refreshGroup(groupIdOrOptions?, searchType?, setting?): void;
    function refreshMasterDetail(modelName, valueOrOptions?): void

    function dynamic(selectorOrOptions, addType, sbuxContent): void;

    function renderInstance(selectorOrOptions): any;
    function render(selectorOrFunction?: string): void;
    function renderEvent(targetmodelName: string): void;


    function openAlert(options: any): void;
    function closeAlert(): void;

    function getCheckbox(modelName, options?): any;
    function setSelectAllCheck(modelName, options?): void;
    function setSelectAllUnCheck(modelName, options?): void;

    function setDatepickerMinDate(modelName, minDate): void;
    function setDatepickerMaxDate(modelName, maxDate): void;
    function setDatepickerPeriodSet(modelName, periodSet): void;
    function getDatepickerFormattedDate(modelName): void;
    function openDatepicker(modelName): void;
    function openDatepickerRange(modelName, openFromDt: boolean, openToDt: boolean): void;
    function closeDatepicker(modelName): void;
    function closeDatepickerRange(modelName, openFromDt: boolean, openToDt: boolean): void;

    function addTab(modelName: string, option: any): void;
    function removeTab(modelName, idOrOption: any): void;
    function removeAllTab(modelName, option?): void;
    function removeOthersTab(modelName, option?): void;
    function getTab(modelName: string, nodeId?: string): any;
    function getTabsCount(modelName: string): number;
    function setTab(modelNameOrTabId, option?): void;
    function selectTab(modelNameOrTabId, option?): void;
    function disableTab(modelNameOrTabId, option?): void;
    function enableTab(modelNameOrTabId, option?): void;
    function showTab(modelNameOrTabId, option?): void;
    function hideTab(modelNameOrTabId, option?): void;
    function setTabContentCSS(modelName, cssJson): void;
    function excludeDraggableTab(modelNameOrTabId, option?): void;
    function includeDraggableTab(modelNameOrTabId, option?): void;
    function moveTab(modelNameOrTabId, option?): void;


    function setBreadcrumb(modelName, menuValueOrOption, keyType?: string) : void;
    function getBreadcrumb(modelName): any;
    function getBreadcrumbStatus(modelName, nodeIds?): any;

    function getMenuStatus(modelName, nodeIds?): any;

    function getTreeStatus(modelName, nodeIds?): any;
    function editTreeNode(modelName: string, nodeId: string, changeNodeData: any): void;
    function removeTreeNode(modelName: string, nodeId: string, callbackAfterRemove?: Function): void;
    function addTreeNode(modelName, addType, addNodeJson, pointNodeId?, callbackAfterAdd?: Function): void;
    function changeChildTreeNode(modelName: string, chidJsonData: any, parentNodeId?: string): void;
    function getTreeUpdateData(modelName:string, options?: any);
    function getTreeSiblingData(modelName: string, rootNodeId: string, distancelevel: number, filterKey?: string): any;
    function expandTreeNodes(modelName: string, targetNodeId: string, distancelevel: number): void;
    function expandTreeChildNodes(modelName: string, targetNodeId: string, distanceLevel: number, isExpandTargetNode?: boolean): void;
    function collapseTreeNodes(modelName, targetNodeId, distLevel): void;
    function collapseTreeChildNodes(modelName, targetNodeId, distLevel, isExpandTarget?): void;


    function addAccordion(modelName: string, options: any): void;
    function removeAccordion(modelName: string, itemId?: string|number): void;
    function setAccordion(modelName, itemId, options?): void;


    function addCarouselSlide(modelName: string, options: any|string, positionIndex: number|string): void;
    function removeCarouselSlide(modelName: string, positionIndex: number|string): void;
    function setCarouselSlide(modelName: string, positionIndex: number|string): void;
    function getCarousel(modelName, selectNum?): any;
    function getCarouselSlide(modelName): any;
    function getCarouselCount(modelName: string): number;

    function setSideMenu(modelName: string, menuValue: string, menuValueKey?: string): void;
    function getSideMenu(modelName: string): any;
    function disableSideMenu(modelName: string, menuValue: string, menuValueKey?: string): void;
    function enableSideMenu(modelName: string, menuValue: string, menuValueKey?: string): void;
    function expandSideMenu(modelName: string, targetMenuId?: string, distanceLevel?: number, isExpandTargetMenu?: boolean) : void;
    function collapseSideMenu(modelName, targetMenuId?, closeLevel?, isCollapseTarget?): void;
    function openSideMenu(modelName: string): void;
    function closeSideMenu(modelName: string): void;
    function getSideMenuUpdateData(modelName, option?): any;
    function getSideMenuChangedOrderData(modelName, option?): any;
    function getSideMenuChangingOrderData(modelName, option?): any;


    function getModalStatus(modelName: string): void;
    function setModalTitle(modelName: string, data: string): void;
    function setModalBody(modelName: string, data: string): void;
    function setModalFooter(modelName: string, data: string): void;
    function openModal(modelName: string): void;
    function closeModal(modelName: string): void;


    function promiseProgress(modelName: string, func:Function, delayTime?: string): void;
    function promiseProgressExt(modelNm: string, exeFunc: any, delaytime?): void;
    function promiseProgressWorker(modelNm: string, exeFunc: any, callFunc: any): void;
    function openProgress(modelName: string): void;
    function closeProgress(modelName: string): void;
    function getProgressStatus(modelNm): any;

    function clearFileSingleExt(modelNmOrOptions): any;
    function getFileUpdateData(modelNmOrOptions, whereCondition?): any;
    function setFileButtonStatus(modelNm, attrName, attrValue): void;

    function setSlider(modelNm, value): void;
    function getSlider(modelNm): void;

    function setSwitchStatus(modelNm: string, value): void;
    function getSwitchStatus(modelNm: string, value?): void;
    function changeSwitchLabel(modelNm, options): void;

    function showImageviewer(options: any): void;
    function closeImageviewer(id): void;

    function popupWindow(url: string, title: string, width: number|string, height: number|string): void;
    function popupLayer(url: any, title?: string, width?: number, height?: number, posX?: number, poxY?: number): void;
    function closePopupLayer(id): void;

    function closeContextmenu(): void;

    function getUser(): any;

    function validateRequired(options?: any, jqForm?: any): boolean;

    function confirmWindowClose(func): void;


    function _showTreeVline(modelName, isValid?): void;
    function _setTimerBind(timerId, callbackName): void;
    function _digestBind(timerId, callbackName, arrBindTarget?): void;

    function _confirmTabCtrlRemain(options: any): void;
}

declare namespace _SBUxG {
    function set(modelName: string, value: string, option?:any): void;
    function setText(modelName, value, options?): void;
    function setValue(modelName, value, options?): void;
    function setIndex(modelName, value, options?): void;
    function setExt(selector, compAttr, data): void;


    function get(modelName: string): any;
    function getText(modelName: string): any;
    function getValue(modelName: string): any;
    function getInstanceEvent(modelName: string): any;
    function getExt(selector, compAttr): any;
    function getAttrExt(selector, compAttr): any;

    function clear(modelName: string): void;
    function attr(modelName: string, attrName: string, attrValue: string|boolean): void;
    function getAttr(modelName: string): any;
    function focus(modelName: string): void;

    function setLocalStorage(key, data): void;
    function getLocalStorage(key): any;

    function getSysLog(): any;
    function getLog(): any;

    function eventCall(modelName: string, attrName: string): void;

    function changeLocale(locale: string): void;
    function changeLocaleWithFile(localeName: string, fileUrl?: string, applyAll?: boolean): void;
    function changeLocaleWithJson(localeName: string, jsonData: string, applyAll?: boolean): void;

    function dataBind(jsonData, option): void;

    function getAllData(returnType?: string, omit?: boolean, compType?: string): void;
    function getSubscribeData(dtmodelName, reJsonOrOption?: any, isCompact?: boolean, componentType?: string): any;

    function clearAllData(compType?: string): void;
    function clearSubscribeData(dtmodelName, compTypeOrOptions?: any): any;

    function getComponents(): any;
    function clearStructure(option?: any): void;

    function exportImage(fileName, selector?): void;
    function exportBinaryImage(funcName, selector?): void;
    function exportImageData(funcName, selector?): void;
    function exportPdf(fileName, selector?): void;

    function getNamespaceData(namespaceId: string): any;
    function clearNamespaceData(namespaceId: string): any;
    function refreshNamespaceData(namespaceId: string, setting?): any;

    function changeGroupAttr(groupId: string, attrName: string, attrValue: string|boolean): void;
    function showGroup(groupId: string): void;
    function hideGroup(groupId: string): void;
    function getGroupData(groupId: string, returnType?: string, omit?: boolean, compType?: string): any;
    function clearGroupData(groupId: string, compType?: string): void;


    function calcHistogram(jsonData: object, column: string, textJson: object): any;
    function calcAxisData(jsonData: object, axisX: string, axisY: string): any;
    function calcStackData(options: object): any;

    function getGridCompsData(gridIdOrOptions: any, returnJsonType?: string, isCompact?: boolean, searchType?: string): any;
    function clearGridCompsData(gridIdOrOptions: any, searchType?: string): void;
    function sendCompsDataToGrid(gridIdOrOptions: any): void;
    function disConnectCompToGrid(modelName: string): void;
    function initGridConnection(gridId: string, options?: any): void;
    function connectGridToComps(gridId: string, options?: any): void;
    function connectAllGridToComps(gridId?: string, options?: any): void;

    function setGridRowDataToComps(gridId: string, rowJsonData: any): void;
    function setGridCellDataToComp(gridId, gridRefName, value, options?): void;


    function show(modelName: string): void;
    function hide(modelName: string): void;
    function refresh(modelName: string, attributes?:any): void;
    function secondRefresh(modelName): void;

    function refreshAll(attributes?: any): void;

    function refreshGroup(groupIdOrOptions?, searchType?, setting?): void;
    function refreshMasterDetail(modelName, valueOrOptions?): void

    function dynamic(selectorOrOptions, addType, sbuxContent): void;

    function renderInstance(selectorOrOptions): any;
    function render(selectorOrFunction?: string): void;
    function renderEvent(targetmodelName: string): void;


    function openAlert(options: any): void;
    function closeAlert(): void;

    function getCheckbox(modelName, options?): any;
    function setSelectAllCheck(modelName, options?): void;
    function setSelectAllUnCheck(modelName, options?): void;

    function setDatepickerMinDate(modelName, minDate): void;
    function setDatepickerMaxDate(modelName, maxDate): void;
    function setDatepickerPeriodSet(modelName, periodSet): void;
    function getDatepickerFormattedDate(modelName): void;
    function openDatepicker(modelName): void;
    function openDatepickerRange(modelName, openFromDt: boolean, openToDt: boolean): void;
    function closeDatepicker(modelName): void;
    function closeDatepickerRange(modelName, openFromDt: boolean, openToDt: boolean): void;

    function addTab(modelName: string, option: any): void;
    function removeTab(modelName, idOrOption: any): void;
    function removeAllTab(modelName, option?): void;
    function removeOthersTab(modelName, option?): void;
    function getTab(modelName: string, nodeId?: string): any;
    function getTabsCount(modelName: string): number;
    function setTab(modelNameOrTabId, option?): void;
    function selectTab(modelNameOrTabId, option?): void;
    function disableTab(modelNameOrTabId, option?): void;
    function enableTab(modelNameOrTabId, option?): void;
    function showTab(modelNameOrTabId, option?): void;
    function hideTab(modelNameOrTabId, option?): void;
    function setTabContentCSS(modelName, cssJson): void;
    function excludeDraggableTab(modelNameOrTabId, option?): void;
    function includeDraggableTab(modelNameOrTabId, option?): void;
    function moveTab(modelNameOrTabId, option?): void;


    function setBreadcrumb(modelName, menuValueOrOption, keyType?: string) : void;
    function getBreadcrumb(modelName): any;
    function getBreadcrumbStatus(modelName, nodeIds?): any;

    function getMenuStatus(modelName, nodeIds?): any;

    function getTreeStatus(modelName, nodeIds?): any;
    function editTreeNode(modelName: string, nodeId: string, changeNodeData: any): void;
    function removeTreeNode(modelName: string, nodeId: string, callbackAfterRemove?: Function): void;
    function addTreeNode(modelName, addType, addNodeJson, pointNodeId?, callbackAfterAdd?: Function): void;
    function changeChildTreeNode(modelName: string, chidJsonData: any, parentNodeId?: string): void;
    function getTreeUpdateData(modelName:string, options?: any);
    function getTreeSiblingData(modelName: string, rootNodeId: string, distancelevel: number, filterKey?: string): any;
    function expandTreeNodes(modelName: string, targetNodeId: string, distancelevel: number): void;
    function expandTreeChildNodes(modelName: string, targetNodeId: string, distanceLevel: number, isExpandTargetNode?: boolean): void;
    function collapseTreeNodes(modelName, targetNodeId, distLevel): void;
    function collapseTreeChildNodes(modelName, targetNodeId, distLevel, isExpandTarget?): void;


    function addAccordion(modelName: string, options: any): void;
    function removeAccordion(modelName: string, itemId?: string|number): void;
    function setAccordion(modelName, itemId, options?): void;


    function addCarouselSlide(modelName: string, options: any|string, positionIndex: number|string): void;
    function removeCarouselSlide(modelName: string, positionIndex: number|string): void;
    function setCarouselSlide(modelName: string, positionIndex: number|string): void;
    function getCarousel(modelName, selectNum?): any;
    function getCarouselSlide(modelName): any;
    function getCarouselCount(modelName: string): number;

    function setSideMenu(modelName: string, menuValue: string, menuValueKey?: string): void;
    function getSideMenu(modelName: string): any;
    function disableSideMenu(modelName: string, menuValue: string, menuValueKey?: string): void;
    function enableSideMenu(modelName: string, menuValue: string, menuValueKey?: string): void;
    function expandSideMenu(modelName: string, targetMenuId?: string, distanceLevel?: number, isExpandTargetMenu?: boolean) : void;
    function collapseSideMenu(modelName, targetMenuId?, closeLevel?, isCollapseTarget?): void;
    function openSideMenu(modelName: string): void;
    function closeSideMenu(modelName: string): void;
    function getSideMenuUpdateData(modelName, option?): any;
    function getSideMenuChangedOrderData(modelName, option?): any;
    function getSideMenuChangingOrderData(modelName, option?): any;


    function getModalStatus(modelName: string): void;
    function setModalTitle(modelName: string, data: string): void;
    function setModalBody(modelName: string, data: string): void;
    function setModalFooter(modelName: string, data: string): void;
    function openModal(modelName: string): void;
    function closeModal(modelName: string): void;


    function promiseProgress(modelName: string, func:Function, delayTime?: string): void;
    function promiseProgressExt(modelNm: string, exeFunc: any, delaytime?): void;
    function promiseProgressWorker(modelNm: string, exeFunc: any, callFunc: any): void;
    function openProgress(modelName: string): void;
    function closeProgress(modelName: string): void;
    function getProgressStatus(modelNm): any;

    function clearFileSingleExt(modelNmOrOptions): any;
    function getFileUpdateData(modelNmOrOptions, whereCondition?): any;
    function setFileButtonStatus(modelNm, attrName, attrValue): void;

    function setSlider(modelNm, value): void;
    function getSlider(modelNm): void;

    function setSwitchStatus(modelNm: string, value): void;
    function getSwitchStatus(modelNm: string, value?): void;
    function changeSwitchLabel(modelNm, options): void;

    function showImageviewer(options: any): void;
    function closeImageviewer(id): void;

    function popupWindow(url: string, title: string, width: number|string, height: number|string): void;
    function popupLayer(url: any, title?: string, width?: number, height?: number, posX?: number, poxY?: number): void;
    function closePopupLayer(id): void;

    function closeContextmenu(): void;

    function getUser(): any;

    function validateRequired(options?: any, jqForm?: any): boolean;

    function confirmWindowClose(func): void;


    function _showTreeVline(modelName, isValid?): void;
    function _setTimerBind(timerId, callbackName): void;
    function _digestBind(timerId, callbackName, arrBindTarget?): void;

    function _confirmTabCtrlRemain(options: any): void;
}

declare namespace sb.chart {
    function render(selector: string, options: any): any;
}