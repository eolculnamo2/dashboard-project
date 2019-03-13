<template>
    <div class="seldep__wrap">
        <DeploymentCard v-for="(x,i) in deployments" 
                        :key="x.name+i"
                        :data="x"/>
    </div>
</template>
<script>
import DeploymentCard from './subcomponents/DeploymentCard.vue';
export default {
    components: { DeploymentCard },
    data() {
        return {
            deployments: [
                {
                    name: "Deployment 1",
                    deadline: "4/4/2019",
                    status: "Pending Fixes",
                    pending: 3,
                }
            ]
        }
    }
}
</script>

<style lang="scss">
    .seldep__wrap {
        padding: 2em;
        min-height: 70vh;
    }
</style>


