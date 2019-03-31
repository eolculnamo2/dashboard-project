<template>
  <div class="footer-flex-wrap">
    <div class="footer-text">
      Project by Rob Bertram
    </div>
  </div>
</template>
<script>
export default {
  
}
</script>
<style lang="scss">
  @import '../../settings.scss';
  .footer-flex-wrap {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    background-color: $darkBlue;
    padding: 1.9rem 0;
  }
  .footer-text {
    font-weight: 600;
    color: white;
    font-size: 1.2rem;
  }
</style>
