import {
	createRouter,
	createWebHistory
} from 'vue-router'
import Login from '../components/login.vue'
import UserRegister from '../components/UserRegister.vue'
import correspond from '../components/correspond.vue'
import sessionkey from '../components/sessionKeyList.vue'
import biochange from '../components/changeInfo/bioChange.vue'
import cardchange from '../components/changeInfo/cardChange.vue'
import passwordchange from '../components/changeInfo/passwordChange.vue'
const routes = [{
			path: '/',
			name: 'Login',
			component: Login,
			},
			{
				path: '/correspond',
				name: 'correspond',
				component: correspond
			},
			{
				path: '/user-register',
				name: 'UserRegister',
				component: UserRegister
			},
			{
			path: '/sessionKeys',
			name: 'SessionKeys',
			component: sessionkey,
			},
			{
				path: '/password-change',
				name: 'PasswordChange',
				component: passwordchange
			},
			{
				path: '/bio-change',
				name: 'BioChange',
				component: biochange
			},{
				path: '/card-change',
				name: 'cardChange',
				component: cardchange,
			}
		]
		const router = createRouter({
			history: createWebHistory(process.env.BASE_URL),
			routes
		})

		export default router