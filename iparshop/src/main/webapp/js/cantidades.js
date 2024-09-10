window.addEventListener('DOMContentLoaded', () => {
	const grupos = document.querySelectorAll('.cantidad');
	
//	console.log(grupos);
	
	for(const grupo of grupos) {
//		console.log(grupo);
		
		const botones = grupo.querySelectorAll('button');
		const input = grupo.querySelector('input');
		
//		console.log(botones);
		
		const menos = botones[0];
		const mas = botones[1];
		
//		console.log(menos, mas);
		
		menos.addEventListener('click', () => {
			if(input.value > input.min) {
				input.value--;
			}
		});
		
		mas.addEventListener('click', () => {
			input.value++;
		});
	}
});