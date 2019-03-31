
import Login from './components/pages/Login.vue';
import CreateTeam from './components/pages/CreateTeam.vue';
import Dashboard from './components/pages/Dashboard/Dashboard.vue';
import NewDeployment from './components/pages/Dashboard/subcomponents/new-deployment/NewDeployment.vue';
import DeploymentStatus from './components/pages/Dashboard/subcomponents/deployment-status/DeploymentStatus.vue';
import SelectDeployment from './components/pages/Dashboard/subcomponents/select-deployment/SelectDeployment.vue';


export default [
  {path: '/login', component: Login},
  {path: '/create-team', component: CreateTeam},
  {path: '/dashboard', component: Dashboard,
    children: [
      { 
        path: '/select-deployment',
        component: SelectDeployment
      },
      { 
        path: '/deployment-status',
        component: DeploymentStatus
      },
      {
        path: '/new-deployment',
        component: NewDeployment
      }
    ]
  }
  
]