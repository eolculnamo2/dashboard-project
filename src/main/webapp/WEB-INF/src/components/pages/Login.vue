<template>
    <div>
        <main-header></main-header>
        <div class="login-main-wrap">
            <div class="login-box-wrap">
                <div class="login-left-side">
                    <h3 class="login-big-header">Make Deployments Easy</h3>
                    <ul class="login-check-list">
                        <li>Live deployment notes</li>
                        <li>Post pending fixes.</li>
                        <li>Display deployment notes</li>
                        <li>Customizable profiles</li>
                        <li>Keeps your team informed</li>
                    </ul>
                    <p class="login-explain-text">
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed aliquet aliquet nisi ut tristique. Sed et egestas risus, nec sodales odio. Mauris et nulla interdum arcu ultricies dapibus. Vestibulum sagittis, erat ac bibendum molestie, lectus dui 
                    </p>
                </div>
                <div class="login-right-side">
                    <h3 class="login-big-header login-big-header--t-align-center">Login</h3>
                    <div class="login-credentials-box">
                        <div class="login-credential-text">Username</div>
                        <input class="login-credentials-input"
                               type="text"
                               v-model="username">
                        <div class="login-credential-text">Password</div>
                        <input class="login-credentials-input" 
                               type="password"
                               v-model="password">
                        <div class="login-credentials-flex">
                            <div class="login-credentials-links">Forgot Password?</div>
                            <router-link to="/create-team" exact><div class="login-credentials-links">Create New Team</div></router-link>
                        </div>
                        <button class="login-credentials-button" type="button">
                            Login
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <main-footer></main-footer>
    </div>
</template>
<script>
import Header from '../components/Header.vue';
import Footer from '../components/Footer.vue';
export default {
    components: {
        'main-header': Header,
        'main-footer': Footer
    },
    data() {
        return {
            username: "",
            password: ""
        }
    }
}
</script>
<style lang="scss">
    @import '../../settings.scss';
    .login-main-wrap {
        height: 75vh;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .login-box-wrap {
        display: flex;
        box-shadow: 0 3px 6px rgba(0,0,0, .3);
    }
    .login-left-side {
        width: 460px;
        background: linear-gradient($darkBlue 40%, black);
        color: white;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        padding: 2.8rem 4.3rem;
    }
    .login-right-side {
        width: 460px;
        background: $lightBlue;
        color: $dark1;
        padding: 2.8rem 5rem;
    }

    .login-big-header {
        font-size: 2rem;
        margin-top: 0;

        &--t-align-center {
            margin-bottom: 2.8rem;
            text-align: center;
        }
    }

    .login-check-list {
        font-size: 1.1rem;
        margin-top: 0;
        list-style-type: none;
        padding: 0;

        li {
            margin-top: 1.5rem;

            &:before {
                content: "";
                background: url("../../images/checkmark.png") center center no-repeat;
                padding: 1rem;
                margin-right: 1rem;
            }
        }
    }

    .login-explain-text {
        font-size: .9rem;
    }

    .login-credentials-box {
        max-width: 315px;
        margin: auto;
    }

    .login-credential-text {
        font-size: 1.25rem;
        margin: .5rem 0;
    }
    .login-credentials-input {
        width: 94%;
        padding: 1rem 3%;
        box-shadow: 0 2px 3px rgba(0,0,0, .3);
        border: 0;
        outline: none;
        border: 1px solid $dark2;
        transition: all .3s; 

        &:focus {
            border: 1px solid $darkBlue;
        }
    }

    .login-credentials-flex {
        display: flex;
        justify-content: space-between;
        margin-top: .5rem;
    }

    .login-credentials-links {
        text-decoration: underline;
        cursor: pointer;
        font-size: 1rem;
        &:hover {
            color: $darkBlue;
        }
    }

    .login-credentials-button {
        display: block;
        margin-top: 1rem;
        background-color: $darkBlue;
        color: white;
        padding: .5rem;
        width: 50%;
        font-size: 1.5rem;
        border: 0;
        border-radius: 100px;
        transition: all .2s;
        cursor: pointer;
        outline: 0;
        box-shadow: 0 2px 3px rgba(0,0,0, .3);

        &:hover {
            color: $lightBlue;
        }

        &:active {
            box-shadow: none;
        }

    }
</style>
