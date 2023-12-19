/**
*   Router.js
*	라우팅 로직을 관리하는 js
*/
var Router = function() {
	this.lastLoadedUrl = null;
	console.log("Router initialized.");
};

Router.prototype.isDuplicateNavigation = function(url) {
	if (this.lastLoadedUrl === url) {
		console.log("Duplicate navigation detected.");
		return true;
	}
	this.lastLoadedUrl = url;
	return false;
}

var myRouter = new Router();
