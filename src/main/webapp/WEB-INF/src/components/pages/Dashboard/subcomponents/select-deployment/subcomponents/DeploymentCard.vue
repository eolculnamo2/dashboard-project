<template>
    <div class="depcard__wrap">
        <div class="depcard__head-wrap">
            <h3 class="depcard__heading">{{ this.data.name }}</h3>
        </div>
        <div class="depcard__body">
            <h3 class="depcard__info"><span class="depcard__label">Deadline:</span> <span class="depcard__data">{{ this.data.deadline }}</span></h3>
            <h3 class="depcard__info"><span class="depcard__label">Status:</span> <span class="depcard__data">{{ this.data.status }}</span></h3>
            <h3 class="depcard__info"><span class="depcard__label">Pending:</span> <span class="depcard__data">{{ this.data.pending }}</span></h3>
            <button class="depcard__btn">VIEW</button>
        </div>
    </div>
</template>
<script>
export default {
    props: ['data']
}
</script>

<style lang="scss" scoped>
    @import '../../../../../../settings.scss';
    .depcard__wrap {
        width: 300px;
        border: 1px solid $dark1;
    }
    .depcard__heading {
        margin-top: 0;
        margin-bottom: 0;
    }
    .depcard__info {
        margin-top: 0;
    }
    .depcard__head-wrap {
        background: $lightBlue;
        max-width: 100%;
        padding: 1rem 1.5rem;
        border-bottom: 1px solid $dark1;
    }
    .depcard__body {
        padding: 1.5em;
    }
    .depcard__data {
        color: $dark3;
    }
    .depcard__label {
        display: inline-block;
        width: 90px;
    }
    .depcard__btn {
        background: $darkBlue;
        display: flex;
        align-items: center;
        justify-content: center;
        color: white;
        font-size: 1rem;
        padding: .5rem;
        width: 100%;
        box-sizing: border-box;
        cursor: pointer;
        outline: none;

        &:hover {
            color: $lightBlue;
            box-shadow: 0 2px 3px rgba(0,0,0, .3);
        }
    }
</style>
