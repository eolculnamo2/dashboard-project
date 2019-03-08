<template>
    <div>
         <UpdateBlock/>
           <div class="d-flex-wrap d-body-wrap">
               <div class="d-flexed">
                    <IncludedFixes/>
                    <PendingIssues/>
               </div>
               <DeploymentNotes/>
           </div>
    </div>
</template>
<script>

import UpdateBlock from './UpdateBlocks.vue';
import IncludedFixes from './IncludedFixes.vue'
import DeploymentNotes from './DeploymentNotes.vue';
import PendingIssues from './PendingIssues.vue';

export default {
    components: { UpdateBlock, IncludedFixes, DeploymentNotes, PendingIssues }
}
</script>
<style lang="scss" scoped>
    .d-body-wrap {
        margin: 1.4rem 2rem;
    }
    .d-flexed {
        width: 100%;
    }
    .d-flex-wrap {
    display: flex;
    align-items: flex-start;
    justify-content: space-between;
}
</style>
