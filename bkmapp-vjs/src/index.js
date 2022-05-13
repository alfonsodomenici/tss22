import HomeView from './view/HomeView.js';
import MenuView from './view/MenuView.js';
import LoginView from './view/LoginView.js';
import RegistrationView from './view/RegistrationView.js';
import AboutView from './view/AboutView.js';
import UserHomeView from './view/UserHomeView.js';
import {Router} from './lib/vaadin-router.js';

const outlet = document.getElementById('view');
const router = new Router(outlet);
router.setRoutes([
  {path: '/',     component: 'bkm-home'},
  {path: '/login',     component: 'bkm-login'},
  {path: '/registration',     component: 'bkm-registration'},
  {path: '/about',     component: 'bkm-about'},
  {path: '/user-home',     component: 'bkm-user-home'},
  
]);