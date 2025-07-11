/**
 * 	ViewX.js
 * 	ViewX를 감지하고 관리하는 js
 */
var resetViewX = () => {
	if (typeof viewX === 'undefined' || viewX === null) {
		console.log('viewX is either null or undefined. No need to reset.');
		return;
	}
	var objectSize = 0;
	if (Array.isArray(viewX)) {
		objectSize = viewX.length;
	} else if (typeof viewX === 'object') {
		objectSize = Object.keys(viewX).length;
	}
	viewX = null;
	console.log(
		'viewX has been reset to null. %c' + objectSize + ' global variables%c have been cleared.',
		'color: red;', 
		'color: initial;'
	);
};

(function() {
	var _viewX;
	Object.defineProperty(window, 'viewX', {
		get: function() {
			return _viewX;
		},
		set: function(value) {
			console.log('viewX variable has been set.');
			_viewX = value;
		}
	});
})();
