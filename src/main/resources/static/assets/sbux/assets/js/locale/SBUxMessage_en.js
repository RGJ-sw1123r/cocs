(function() {
    SBUxG.DEF.MSG = {
        // LICENSE
        NOT_FOUND_LICENSE: '[SBUx] The license is not registered.',
        INVALID_LICENSE: '[SBUx] The license is invalid.',
        EXPIRED_LICENSE: '[SBUx] Trial version has expired.',
        UNMATCH_VER_LICENSE: '[SBUx] The license is unmatching product version.',

        //COMMON
        NOT_DEV_API: '[SBUx] SBUxMethod.${attr} API is an undeveloped feature.',
        NOT_DEV_FUNC: '[SBUx] $ {attr1} of the $ {attr} component is an undeveloped feature.',
        NOT_FOUND_TAG: '[SBUx] Not found tag name , wrong tag Name:${attr}',
        NOT_ENTERED_INVALID_TAG: '[SBUx] Please enter the correct tag name , wrong tag Name:${attr}',
        NOT_ENTERED_ATTR: '[SBUx] The attribute ${attr} has not been entered.',
        NOT_PROVIDE_ATTR: '[SBUx] It does not provide functionality with ${attr} attribute',
        NOT_PROVIDE_ATTR_ATTR: '[SBUx] ${attr} does not provide functionality with ${attr1} attribute',
        NOT_PROVIDE_FUNC: '[SBUx] ${attr} is not immediately available.',
        NOT_ENTERED_ID: '[SBUx] The attribute id has not been entered.',
        NOT_ENTERED_NAME: '[SBUx] The attribute name has not been entered.',
        NOT_ENTERED_UITYPE: '[SBUx] The attribute uitype has not been entered.',
        NOT_ENTERED_MODE: '[SBUx] the attribute mode has not been entered.',
        NOT_ENTERED_REQ_ATTRI: '[SBUx] A required attribute was not entered.',
        NOT_EXIST_FORMNAME: '[SBUx] Must have a node name in the form Tag.',
        NOT_EXIST_FORMID: '[SBUx] Must have a node id in the form Tag.',
        OVER_PARAMS: '[SBUx] Parameter number supports up to ten.',
        INVALID_UITYPEVALUE: '[SBUx] Uitype incorrect property values ​​have been entered. Please check your spelling.',
        INVALID_ATTRIVALUE: '[SBUx] Invalid property value has been entered. Please check the spelling.',
        INVALID_ATTRIVALUE_COUNT: '[SBUx] Lack of property values ​​are entered .',
        INVALID_ATTRIVALUE_SPACE: '[SBUx] Space or spaces are not allowed.',
        INVALID_ATTRIVALUE_UNDEFINED: '[SBUx] Undefined is not allowed.',
        MUST_ATTRIVALUE : '[SBUx] The attribute value[${attr}] must be set.',

        NOT_FOUND_TEXT: 'Not Found..',

        INFORMATION_TEXT : 'Information',

        // MESSAGE
        MESSAGE_NOT_FOUND_NAME: '[SBUx] There is no name that can be referenced.',
        MESSAGE_NOT_FOUND_ID: '[SBUx] There is no id that can be referenced.',

        // VALIDATE
        MESSAGE_ONLY_NUMBER: '[SBUx] The number must be entered.',
        MESSAGE_ONLY_STRING: '[SBUx] Only characters to be entered.',
        MESSAGE_ONLY_BOOLEAN: '[SBUx] This must be true or false inputs.',
        MESSAGE_ONLY_PHONE_NUMBER: '[SBUx] Phone numbers can only be numeric',
        MESSAGE_NOT_ALLOWED_RANGE: '[SBUx] Outside the permitted range.',
        MESSAGE_NOT_ALLOWED_DIGIT: '[SBUx] The decimal point is not allowed.',
        MESSAGE_NOT_ALLOWED_MINUS: '[SBUx] Negative values ​​are not allowed.',
        MESSAGE_NOT_ALLOWED_STRING: '[SBUx] Characters are not allowable.',
        MESSAGE_NOT_ALLOWED_SPACE: '[SBUx] Spaces are not allowed.',

        // DATEPICKER
        DATEPICKER_INPUT_FROM_TEXT : 'From Date',
        DATEPICKER_INPUT_TO_TEXT : 'To Date',

        // RADIO
        RADIO_NO_DATA: 'Undefined',

        // CHECKBOX
        CHECKBOX_NO_DATA: 'Undefined',

        // SELECT BOX
        SELECT_NO_DATA: 'No Data',
        SELECT_UNSELECTED: 'Click to Choose..',
        IS_SELECT_ALL_TEXT: 'Select All',
        TITLE_SELECT_MAX_TEXT: ' Selected',
        TITLE_SELECT_ALL_TEXT: 'All Selected',
        SELECT_MAX_COUNT_TEXT : 'No more than ${attr} can be selected',

        // LISTBOX
        LISTBOX_NO_DATA: '',

        // TREE
        SELECT_NODE_NEED_TITLE: 'Tree Info',
        SELECT_NODE_NEED: 'The Selected node is required',
        INVALID_NODE_INFO: 'Invalid node information.',
        AVAILABLE_JSONDATA_TYPE: 'It can only form Json Data',
        NEW_TREE_NODE_TEXT: 'New Node',
        NEW_TREE_NODE_CREATION_FAILED : 'Node creation failed',
        NEW_TREE_NODE_VALUE: '',
        INFO_DELETE_CHILD_NODE: 'Child nodes will also be deleted',
        INFO_DELETE_NODE: 'Delete the node',
        NODE_DUPLICATION_KEY: 'Duplicate key nodes has occurred . Please contact product company.',
        TREE_NO_DATA : 'No Data',

        // Accordion
        ACCORDION_NO_DATA : 'No Accordion data founded.',

        // ALERT
        CONFIRM_OK: 'Ok',
        CONFIRM_CANCEL: 'Cancel',
        CLOSE_ON_FOOTER : 'Ok',

        // DROPDOWN TEXT
        DROPDOWN_TEXT: 'Click to Choose..',
        DROPDOWN_NO_DATA: 'No Dropdown data founded.',

        // COLSE TEXT
        CLOSE_TEXT: 'Close',

        // TAB TEXT
        TAB_MENU_LIST_DEL_CONFIRM_TITLE : 'Tab Info',
        TAB_MENU_LIST_DEL_ALL_DESC : 'Do you want to close the entire tab?',
        TAB_MENU_LIST_DEL_FOCUS_DESC : 'Do you want to close the current tab?',
        TAB_MENU_LIST_DEL_EXCEPT_FOCUS_DESC : 'Do you want to close the tabs except the current one?',
        TAB_MENU_LIST_DEL_EXCEPT_FIXED_DESC : 'Do you want to close the tabs except the fixed one?',

        TAB_DONT_CLOSE : 'All other tabs are inactive.',
        TAB_OPEN_NOTFOUND_LINK : 'The connected screen does not exist.',
        TAB_DONT_REMOVE : 'The tab to delete does not exist',
        TAB_MENU_LIST_DEL_ALL : 'Close all',
        TAB_MENU_LIST_DEL_FOCUS : 'Close',
        TAB_MENU_LIST_DEL_EXCEPT_FOCUS : 'Close Others',
        TAB_MENU_LIST_DEL_EXCEPT : ',Close Others',
        TAB_MENU_DONT_REMOVE : 'Can not be deleted',
        TAB_MENU_CLOSE_CONFIRM_TEXT : '',

        // MENU
        MENU_NO_DATA : 'No Menu data founded.',

        // PROGRESS BAR
        PROGRESS_NOT_ALLOWED_TWOBAR : 'If the indicator-type attribute is a normal value, you must set only one sbux-bar tag.',
        PROGRESS_LOADING_TEXT : 'LOADING',

        // CONTEXT MENU
        CTXT_MENU_DATA_COLLECT : '[SBUx] Error collecting data from child nodes.',
        CTXT_MENU_INVALID_SELECTOR : '[SBUx] Check the selector in ${attr}.',

        // SBGRID
        NOT_ENTERED_COLUMS: '[SBUx] No information that can be referenced column.',
        NOT_ENTERED_STYLE : '[SBUx] There is no style information that determines the width and heigth of the grid.',
        NO_ROWS_SELECTED : '[SBUx] You must select a row within the grid.',

        // IE9 Required
        IE9_NOT_ENTERED_REQ_COMMON: 'It is required.',
        IE9_NOT_ENTERED_REQ_INPUT: 'Please fill out this field.',
        IE9_NOT_ENTERED_REQ_SELECT: 'Please select an item from the list.',
        IE9_NOT_ENTERED_REQ_CHECK: 'Please, The essential choices.',
        IE9_NOT_ENTERED_REQ_RADIO: 'Please, The essential choices.',
        IE9_NOT_ENTERED_REQ_PICKER: 'Please, Select a date',
        IE9_NOT_ENTERED_REQ_DROPDOWN: 'Please select an item from the list.',

        // Minlength
        IE_MINLENGTH_REQ_INPUT : 'Please increase this text to at least * characters (currently # character in use).',

        // integer maxlength
        INTEGER_MAXLENGTH_REQ_INPUT : 'Limit this integer value to * characters or less(currently # character in use).',
        INTEGER_MINLENGTH_REQ_INPUT : 'Please increase this integer value to at least * characters (currently # character in use).',

        // DATA STORE
        DATA_RECEIVE_LOADING_TITLE: 'Loading data',
        DATA_RECEIVE_LOADING_TEXT: 'Please wait...',
        DATA_RECEIVE_ERROR_TITLE: 'Data loading error.',
        DATA_RECEIVE_ERROR_TEXT: 'Please check your network connection.',
        DATA_SEND_JSONDATA_ERROR: '[SBUx] This is a syntax error Send Data.',
        DATA_NETWORK_ERROR_TITLE: 'Network Connection Error.',
        DATA_NETWORK_ERROR_TEXT: 'The problem occurred on the network connection.',

        // COMMON ERROR_MSG
        JSONDATA_MUST_HAVE: 'The jsondata-ref property is required.',
        JSONDATA_NOT_FOUND: 'Can not find an object associated with the jsondata-ref.',
        JSONDATA_ALREADY_CHANGED: 'There are already changes in JSON format. Please Remove Property, datastore-data-type="json" ',

        // SBGrid
        SBGRID21_NOT_IMPORT: '[SBUx] SBGrid 2.1 File Not Found. Please Add, SBGrid : { Version2_1 : true }  in SBUxConfig settings.',
        SBGRID25_NOT_IMPORT: '[SBUx] SBGrid 2.5 File Not Found. Please Add, SBGrid : { Version2_5 : true } in SBUxConfig settings.',

        // Carousel
        CAROUSEL_NOT_FOUND : 'No slides to display.',

        // Side menu
        SIDEMENU_NO_DATA : 'No Data',
        SIDEMENU_FILTER_PLACEHOLDER : 'Search',

        // floating
        FLOATING_NO_DATA : 'No Data',
        FLOATING_FILTER_PLACEHOLDER : 'Search',

        // Fileupload
        HEADER_TITLE : 'Attachment file list',
        HEADER_FILENAME : 'File Names',
        ADD_FILE : 'Add Files',
        CANCEL_FILE : 'Cancel Files',
        UPLOAD_ALL_FILE : 'Upload All Files',
        DELETE_FILE : 'Delete Files',

        // Web Editor Button
        EDITOR_BUTTON_PARAGRAPH : 'Paragraph',
        EDITOR_BUTTON_BOLD   : 'Bold',
        EDITOR_BUTTON_UNDERLINE  : 'Underline',
        EDITOR_BUTTON_ITALIC : 'Italic',
        EDITOR_BUTTON_STROKE : 'Stroke through',
        EDITOR_BUTTON_BULLET_LIST : 'Bulleted List',
        EDITOR_BUTTON_NUM_LIST : 'Numeric List',
        EDITOR_BUTTON_PICTURE : 'Picture',
        EDITOR_BUTTON_LINK : 'Link',
        EDITOR_BUTTON_CLEAN : 'Clean',
        EDITOR_BUTTON_PREVIEW : 'Preview',

        EDITOR_BUTTON_PICTURE_MSG : 'Image Source',
        EDITOR_BUTTON_PICTURE_ALT_MSG : 'Alternative text',
        EDITOR_BUTTON_LINK_MSG : 'Link',

        // image viewer
        IMAGEVIEWER_UNTITLED : 'untitled',

        // web accessibility
        WEB_ACCESS_UNTITLED : 'untitled',

        // localstorage
        TO_USE_LOCALSTORAGE : '[SBUx] To use SystemLogType:"storage" or DeveloperTipType: "storage" in the SBUxConfig settings, you must start with http or https in the address bar. Change to the "console" type for the system to work.'
    };

    SBUxG.DEF.MSG_VALIDATE = {
        INPUT : 'Please confirm input condition',
        DATEPICKER : 'Please check the date entry conditions',
        RADIO : 'Please confirm selection condition',
        CHECKBOX : 'Please confirm selection condition',
        SELECT : 'Please confirm selection condition',
        TEXTAREA : 'Please confirm input condition',
        LISTBOX : 'Please confirm selection condition',
        DROPDOWN : 'Please confirm selection condition'
    };

}());