import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const routes = [
	{
		path: '/',
		name: 'Main',
		component: () => import('@/views/MainPage.vue'),
	},
	{
		path: '/teams/:teamName',
		name: 'TeamPage',
		component: () => import('@/views/TeamPage.vue'),
	},
	// {
	//   path: '/about',
	//   name: 'About',.
	//   component: () => import(/* webpackChunkName: "about" */ '../views/About.vue'),
	// },
];

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes,
});

export default router;
