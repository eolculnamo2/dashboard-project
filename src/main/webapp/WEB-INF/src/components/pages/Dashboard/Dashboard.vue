<template>
    <div class="d-flex-wrap">
        <LeftMenu/>
        <div class="d-right-side">
           <div class="d-header">
               <h1 class="d-big-header">Dashboard Status</h1>
               <div class="d-schedule-time">
                   <div>Scheduled Time</div>
                   <div>March 1, 2018 - 8:00AM</div>
               </div>
           </div>
           <UpdateBlock/>
           <div class="d-flex-wrap d-body-wrap">
               <div class="d-flexed">
                    <IncludedFixes/>
                    <PendingIssues/>
               </div>
               <DeploymentNotes/>
           </div>
           <div class="d-project-by">Project by Rob Bertram</div>
        </div>
    </div>
</template>
<script>
import LeftMenu from './subcomponents/LeftMenu.vue';
import UpdateBlock from './subcomponents/UpdateBlocks.vue';
import IncludedFixes from './subcomponents/IncludedFixes.vue'
import DeploymentNotes from './subcomponents/DeploymentNotes.vue';
import PendingIssues from './subcomponents/PendingIssues.vue';
export default {
    components: { LeftMenu, UpdateBlock, IncludedFixes, DeploymentNotes, PendingIssues }
}
</script>
<style lang="scss" scoped>
    @import '../../../settings';
    .d-flex-wrap {
        display: flex;
        align-items: flex-start;
        justify-content: space-between;
    }
    .d-header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 1.6rem 2.3rem 1.4rem 2.3rem;
        border-bottom: 1px solid $darkBlue;
    }
    .d-right-side {
        flex-grow: 1;
    }
    .d-big-header {
        font-size: 2.5rem;
        font-weight: 500;
        margin: 0;
        color: $dark1;
    }
    .d-schedule-time {
        font-size: 1.25rem;
        color: $dark1;
    }
    .d-body-wrap {
        margin: 1.4rem 2rem;
    }
    .d-flexed {
        width: 100%;
    }
    .d-project-by {
        text-align: center;
        font-size: 1rem;
        margin-bottom: 1rem;
    }
</style>
