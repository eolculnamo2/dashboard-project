<template>
    <div class="header-wrap">
         <router-link to="/" exact>
            <h1 class="header-main-title">
                Deployment Status
            </h1>
         </router-link>
    </div>
</template>
<script>
export default {
    
}
</script>
<style lang="scss">
    @import '../../settings.scss';
    .header-wrap {
        border-bottom: 6px solid $darkBlue;
    }
    .header-main-title {
        font-size: 2.55rem;
        color: $dark1;
        margin-left: 3rem;
    }
</style>
