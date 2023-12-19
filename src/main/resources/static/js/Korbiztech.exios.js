/**
 *  Korbiztech.exios.js
 *  A custom HTTP request library inspired by axios. 
 *  This is NOT the actual axios library but aims to provide similar functionality.
 *  Created for vanilla JavaScript projects and designed to be easily integrated into future Vue.js projects.
 */
const makeAjaxRequest = (method, url, data, config) => {
	return new Promise((resolve, reject) => {
		const xhr = $.ajax({
			...config,
			method,
			url,
			contentType: 'application/json',
			data: JSON.stringify(data),
			success: (response) => {
				resolve({ data: response });
			},
			error: (error) => {
				reject(error);
			},
			complete: () => {
				const index = exios.cancelTokens.indexOf(xhr);
				if (index > -1) {
					exios.cancelTokens.splice(index, 1);
				}
			}
		});
		exios.cancelTokens.push(xhr);
	});
};

const exios = {
	cancelTokens: [],
	get(url, configOrParams = {}) {
		return new Promise((resolve, reject) => {
			let finalConfig = {};
			if (typeof configOrParams === 'object' && !configOrParams.params) {
				finalConfig.params = configOrParams;
			} else {
				finalConfig = configOrParams;
			}
			const xhr = $.ajax({
				url,
				data: finalConfig.params,
				success: (data) => {
					resolve({ data });
				},
				error: (error) => {
					reject(error);
				},
				complete: () => {
					const index = this.cancelTokens.indexOf(xhr);
					if (index > -1) {
						this.cancelTokens.splice(index, 1);
					}
				}
			});
			this.cancelTokens.push(xhr);
	    }).catch((error) => {
			console.error('Something went wrong:', error);
        });
	},
	post(url, data, config = {}) {
		return makeAjaxRequest('POST', url, data, config);
	},
	put(url, data, config = {}) {
		return makeAjaxRequest('PUT', url, data, config);
	},
	patch(url, data, config = {}) {
		return makeAjaxRequest('PATCH', url, data, config);
	},
	delete(url, data, config = {}) {
		return makeAjaxRequest('DELETE', url, data, config);
	}
};
