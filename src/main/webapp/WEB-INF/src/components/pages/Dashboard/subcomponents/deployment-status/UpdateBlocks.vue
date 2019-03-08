<template>
    <div class="ub-main-wrap">
        <div class="ub-flex-wrap">
            <div class="ub-square ub-complete">
                Tickets Complete
            </div>
            <div class="ub-square ub-complete">
                Test on Local
            </div>
            <div class="ub-square ub-stopped">
                Pending Fixes
            </div>
            <div class="ub-square">
                Deploying
            </div>
            <div class="ub-square">
                Deployment Finalized
            </div>
            <div class="ub-square">
                All Clear on Production
            </div>
            <div class="ub-line"></div>
        </div>
    </div>
</template>
<style lang="scss">
    @import '../../../../../settings.scss';
    .ub-flex-wrap {
        display: flex;
        justify-content: space-between;
        padding: 1.4rem 0;
        margin: 0 2rem;
        position: relative;
        overflow: hidden;
    }
    .ub-main-wrap {
        border-bottom: 1px solid $darkBlue;
    }
    .ub-square {
        width: 125px;
        height: 94px;
        box-shadow: 0px 2px 4px rgba(0,0,0, .3);
        display: flex;
        justify-content: center;
        align-items: center;
        text-align: center;
        background-color: $gray1;
        color: $dark4;
        z-index: 2;
    }
    .ub-complete {
        background-color: #D9F7B9;
        color: #386707;
    }
    .ub-stopped {
        background-color: #FDD3E3;
        color: #691535;
    }
    .ub-line {
        position: absolute;
        height: 1px;
        background: $darkBlue;
        width: 100%;
        transform: translateY(47px);
    }
</style>

