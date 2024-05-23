import {
	createRouter,
	createWebHistory
} from 'vue-router'
import CarRegister from '../components/CarRegister.vue'
import correspond from '../components/correspond.vue'

const routes = [{
			path: '/',
			name: 'register',
			component: CarRegister,
			},
			{
				path: '/correspond',
				name: 'correspond',
				component: correspond,
			}
		]
		const router = createRouter({
			history: createWebHistory(process.env.BASE_URL),
			routes
		})

		export default router