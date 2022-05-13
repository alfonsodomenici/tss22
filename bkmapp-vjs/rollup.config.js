import { nodeResolve } from '@rollup/plugin-node-resolve';
export default [{
  input: ['./node_modules/@vaadin/router/dist/vaadin-router.js',
  './node_modules/lit-html/lit-html.js'],
  output: {
    	dir: "src/lib",
    	format: 'esm'
  	},
  plugins: [nodeResolve({
		browser:true
	})]
}]
