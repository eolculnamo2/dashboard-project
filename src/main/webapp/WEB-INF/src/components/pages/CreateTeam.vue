<template>
    <div>
        <main-header></main-header>
            <div class="ct-main-wrap">
                <div class="ct-head">
                    <h3 class="ct-head-header">
                        Create New Team
                    </h3>
                </div>
                <div class="ct-body">
                    <h1 class="ct-big-header">
                        Admin Credentials
                    </h1>
                    <div class="ct-flex-wrap">
                        <div>
                            <div class="ct-label">Team Name</div>
                            <input class="ct-input"
                                   type="text"
                                   v-model="teamname">
                        </div>
                        <div>
                            <div class="ct-label">Admin Display Name</div>
                            <input class="ct-input"
                                   type="text"
                                   v-model="adminDisplayName">
                        </div>
                        <div>
                            <div class="ct-label">Admin Username</div>
                            <input class="ct-input"
                                   type="text"
                                   v-model="adminUsername">
                        </div>
                        <div>
                            <div class="ct-label">Admin Password</div>
                            <input class="ct-input"
                                   type="password"
                                   v-model="adminPassword">
                        </div>
                        <div>
                            <div class="ct-label">Admin Email</div>
                            <input class="ct-input"
                                   type="text"
                                   v-model="adminEmail">
                        </div>
                        <div>
                            <div class="ct-label">Confirm Password</div>
                            <input class="ct-input"
                                   type="password"
                                   v-model="confirmPassword">
                        </div>
                    </div>
                    <h1 class="ct-big-header ct-big-header--xtra-margin">
                        Add Team Members
                    </h1>
                    <div class="ct-flex-wrap">
                        <div class="ct-teammate"
                             v-for="(x,i) in teammates" 
                             :key="i+'teammate'">
                            <div class="ct-label">Team Member Email</div>
                            <input class="ct-input"
                                   type="text"
                                   v-model="x.email">
                            <input class="ct-checkbox" type="checkbox" v-model="x.isAdmin">
                            <span>Has Admin Priviledges</span>
                        </div>
                        <div>
                            <button class="ct-fab"
                                    @click="deleteTeammate()"><span>-</span></button>
                            <button class="ct-fab"
                                    @click="addTeammate()"><span>+</span></button>
                        </div>
                    </div>
                    <button class="ct-create-btn"
                            type="button"
                            @click="createTeam()">Create Team</button>
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
            teamname: "",
            adminDisplayName: "",
            adminUsername: "",
            adminPassword: "",
            adminEmail: "",
            confirmPassword: "",
            teammates: [
                {
                    email: "",
                    isAdmin: false
                }
            ]
        }
    },
    methods: {
        createTeam() {

            const payload = {
                teamname: this.teamname,
                adminDisplayName: this.adminDisplayName,
                adminUsername: this.adminUsername,
                adminPassword: this.adminPassword,
                adminEmail: this.adminEmail,
                confirmPassword: this.confirmPassword,
                teammates: this.teammates
            }

            fetch('/create-team',{
                method: "POST",
                body: JSON.stringify(payload),
                headers: { "Content-Type": "application/json" },
                credentials: "same-origin"
            })
           // .then(() => window.location.href="/");
        },
        addTeammate() {
            this.teammates.push({
                email: "",
                isAdmin: false
            });
        },
        deleteTeammate() {
            if(this.teammates.length > 1) {
                this.teammates.pop();
            }
        }
    }
}
</script>
<style lang="scss">
    @import '../../settings.scss';
    .ct-main-wrap {
        max-width: 915px;
        margin: auto;
        margin-top: 2em;
        margin-bottom: 2em;
        border: 1px solid $dark3;
        box-shadow: 0 2px 3px rgba(0,0,0, .3);
    }
    .ct-head {
        background-color: $darkBlue;
        padding: .75rem 1em;
    }
    .ct-head-header {
        color: white;
        font-weight: 600;
        font-size: 1.25rem;
        margin: .3rem 0;
    }
    .ct-body {
        margin: 0 5rem;
    }
    .ct-big-header {
        font-size: 2rem;
        font-weight: 500;
        color: $darkBlue;

        &--xtra-margin {
            margin-top: 3rem;
        }
    }
    .ct-label {
        font-size: 1.25rem;
        margin: 1rem 0 .25rem 0;
    }
    .ct-input {
        width: 311px;
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
    .ct-checkbox {
        margin-left: 2em;
    }
    .ct-flex-wrap {
        display: flex;
        justify-content: space-between;
        flex-wrap: wrap;
        align-items: flex-end;
    }
    .ct-teammate {
        width: 75%;
    }
    .ct-fab{
        width: 55px;
        height: 55px;
        background-color: $darkBlue;
        color: white;
        display: inline-flex;
        align-items: center;
        justify-content: center;
        border: 0;
        border-radius: 50%;
        font-size: 1.2rem;
        outline: none;
        box-shadow: 0 5px 12px rgba(0,0,0, .3);
        cursor: pointer;
        margin-right: .75rem;
        transition: all .3s;

        &:hover {
            box-shadow: 0 5px 12px rgba(0,0,0, .6);
        }

        &:active {
            box-shadow: 0 9px 24px rgba(0,0,0, .6);
        }
    }
    .ct-create-btn {
        background: $darkBlue;
        width: 311px;
        padding: .5rem 3%;
        color: white;
        font-weight: 600;
        font-size: 1.5rem;
        margin: 1.5rem 0;
        cursor: pointer;
        box-shadow: 0 2px 3px rgba(0,0,0, .3);
        outline: 0;
        border: 0;
        transition: all .2s;

        &:hover {
            color: $lightBlue;
        }

        &:active {
            box-shadow: 0 3px 6px rgba(0,0,0, .3);
        }
    }
</style>
