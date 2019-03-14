<template>
    <div class="lm-main-wrap">
        <div class="lm-top-box">
            <div>
                <div class="lm-profile-picture"></div>
                <h3 class="lm-profile-name">dale12</h3>
            </div>
        </div>
        <div class="lm-bottom-box">
            <ul class="lm-links">
                <li class="lm-live-updates"
                    :class="{'lm-links--current': $route.path === '/deployment-status' || $route.path === '/select-deployment'}">
                    <router-link to="/select-deployment">Live Update</router-link>
                </li>
                <li class="lm-new-dep"
                    :class="{'lm-links--current': $route.path === '/new-deployment'}">
                    <router-link to="/new-deployment">New Deployment</router-link>
                </li>
                <li class="lm-settings">Settings</li>
                <li class="lm-logout"><a href="/logout">Logout</a></li>
            </ul>
        </div>
    </div>
</template>
<style lang="scss">
    @import '../../../../settings.scss';

    .lm-main-wrap {
        width: 290px;
        display: flex;
        flex-direction: column;
        height: 100vh;
        box-shadow: 3px 3px 6px rgba(0,0,0, .3);
        position: sticky;
        top:0;
    }
    .lm-top-box {
        display: flex;
        align-items: flex-end;
        justify-content: center;
        border-bottom: 1px solid $lightBlue;
        background: $darkBlue;
    }
    .lm-profile-picture {
        height: 85px;
        width: 85px;
        border-radius: 50%;
        background: gray;
        margin-top: 2rem;
    }
    .lm-profile-name {
        font-size: 1.8rem;
        color: white;
        font-weight: 500;
        margin-top: .7rem;
        margin-bottom: 1.4rem;
    }
    .lm-bottom-box {
        flex-grow: 1;
        background: linear-gradient($darkBlue 45%, black);
    }
    .lm-links {
        list-style-type: none;
        padding-left: 3.5rem;
        color: $lightBlue;

        li {
            cursor: pointer;
            font-size: 1.1rem;
            margin-top: 2rem;
        }

        &--current {
            color: white;
            text-decoration: underline;
        }
    }
    .lm-live-updates {
        &:before {
                content: "";
                background: url("../../../../images/live-updates.png") center center no-repeat;
                padding: 1rem;
                margin-right: 1rem;
            }
    }
    .lm-settings {
        &:before {
                content: "";
                background: url("../../../../images/settings-icon.png") center center no-repeat;
                padding: 1rem;
                margin-right: 1rem;
            }
    }
    .lm-logout {
        &:before {
                content: "";
                background: url("../../../../images/logout-icon.png") center center no-repeat;
                padding: 1rem;
                margin-right: 1rem;
            }
    }
    .lm-new-dep {
        &:before {
                content: "";
                background: url("../../../../images/new-deploy-icon.png") center center no-repeat;
                padding: 1rem;
                margin-right: 1rem;
            }
    }
</style>
