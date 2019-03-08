<template>
    <div class="nd_main-wrap">
        <div class="nd_head">
            <h3 class="nd_head-header">Create New Deployment</h3>
        </div>
        <div class="nd_body">
            <div class="nd_side-by-side nd_section-wrap">
                <div>
                    <h1 class="nd_big-header">Deployment Details</h1>
                    <div class="nd_label">Deployment Name</div>
                    <input class="nd_input"
                            type="text">
                    <div class="nd_label">Deployment Date</div>
                    <input class="nd_input"
                            type="text">
                    <div class="nd_label">Deployment Time</div>
                    <input class="nd_input"
                            type="text">
                </div>
                <img class="nd_img" src="../../../../../images/Deployment-img.png" alt="deployment-image">
            </div>
            <div class="nd_section-wrap">
                <div class="nd_side-by-side nd_side-by-side--center">
                    <h1 class="nd_big-header">Included Fixes</h1>
                    <div>
                        <button class="nd_fab"
                                @click="deleteIncludedFix();">-</button>
                        <button class="nd_fab"
                                @click="addIncludedFix();">+</button>
                    </div>
                </div>
                <div class="nd_flex-wrap">
                    <div v-for="(x,i) in includedFixes" :key="'fix'+i">
                        <div class="nd_label">Fix #{{i+1}}</div>
                        <input class="nd_input"
                               type="text"
                               v-model="x.fix">
                    </div>
                </div>
            </div>
            <div class="nd_section-wrap">
                <div class="nd_side-by-side nd_side-by-side--center">
                    <h1 class="nd_big-header">Pending Issues</h1>
                    <div>
                        <button class="nd_fab"
                                @click="deletePendingIssue();">-</button>
                        <button class="nd_fab"
                                @click="addPendingIssue();">+</button>
                    </div>
                </div>
                <div class="nd_flex-wrap">
                    <div class="nd_100" v-for="(x,i) in pendingIssues" :key="'pendingIssue'+i">
                        <div class="nd_label">Fix #{{i+1}}</div>
                        <div class="nd_side-by-side">
                            <input class="nd_input"
                                type="text"
                                >
                            <select class="nd_select" v-model="x.assignedTo">
                                <option value="Rob">Rob</option>
                                <option value="Joe">Joe</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="nd_section-wrap nd_section-wrap--no-bdr">
                <div class="nd_side-by-side nd_side-by-side--center">
                    <h1 class="nd_big-header">Deployment Notes</h1>
                    <div>
                        <button class="nd_fab"
                                @click="deleteDeploymentNote();">-</button>
                        <button class="nd_fab"
                                @click="addDeploymentNote();">+</button>
                    </div>
                </div>
                    <div class="nd_100" v-for="(x,i) in deploymentNotes" :key="'pendingIssue'+i">
                        <div class="nd_label">Note #{{i+1}}</div>
                        <textarea class="nd_input nd_input--full"/>
                </div>
            </div>
             <button class="nd_create-btn"
                            type="button"
                            >Create Deployment</button>
        </div>
    </div>
</template>
<script>
export default {
    data() {
        return {
            includedFixes: [
                {fix: ""},{fix: ""},{fix: ""}
            ],
            pendingIssues: [
                {name: "", assignedTo: ""},
                {name: "", assignedTo: ""}
            ],
            deploymentNotes: [
                {note:""}
            ]
        }
    },
    methods: {
        addIncludedFix() {
            this.includedFixes.push({name:""});
        },
        deleteIncludedFix() {
            this.includedFixes.pop();
        },
        addPendingIssue() {
            this.pendingIssues.push({name: "", assignedTo: ""});
        },
        deletePendingIssue(){
            this.pendingIssues.pop();
        },
        addDeploymentNote(){
            this.deploymentNotes.push({note: ""});
        },
        deleteDeploymentNote() {
            this.deploymentNotes.pop();
        }
    }
}
</script>
<style lang="scss" scoped>
    @import '../../../../../settings.scss';
    .nd_main-wrap {
        margin: auto;
        margin-top: 2em;
        margin-bottom: 2em;
        border: 1px solid $dark4;
        max-width: 1050px;
    }
    .nd_head {
        background-color: $darkBlue;
        padding: .75rem 1em;
    }
    .nd_head-header {
        color: white;
        font-weight: 600;
        font-size: 1.25rem;
        margin: .3rem 0;
    }
    .nd_big-header {
        font-size: 2rem;
        font-weight: 500;
        color: $darkBlue;
    }
    .nd_body {
        margin: 0 5rem;
    }
    .nd_side-by-side {
        display: flex;
        justify-content: space-between;

        &--center {
            align-items: center;
        }
    }
    .nd_img {
        width: 400px;
        margin:1rem;
        margin-top: 2rem;
        margin-right: 0;
        align-self: center;
    }
    .nd_label {
        font-size: 1.25rem;
        margin: 1rem 0 .25rem 0;
    }
    .nd_input {
        box-sizing: border-box;
        width: 400px;
        padding: 1rem 3%;
        box-shadow: 0 2px 3px rgba(0,0,0, .3);
        border: 0;
        outline: none;
        border: 1px solid $dark2;
        transition: all .3s; 

        &:focus {
            border: 1px solid $darkBlue;
        }

        &--full {
            width: 100%;
            min-height: 100px;
        }
    }
    .nd_section-wrap {
        padding-bottom: 3rem;
        border-bottom: 1px solid $darkBlue;

        &--no-bdr {
            border-bottom: 0;
        }
    }
    .nd_fab{
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
    .nd_flex-wrap {
        display: flex;
        justify-content: space-between;
        flex-wrap: wrap;
        align-items: flex-end;
    }
    .nd_select {
        width: 400px;
        height: 50px;
    }
    .nd_100 {
        width: 100%;
    }
    .nd_create-btn {
        background: $darkBlue;
        width: 500px;
        padding: .5rem 3%;
        color: white;
        font-weight: 600;
        font-size: 1.5rem;
        margin: auto;
        margin-bottom: 1.5rem;
        display: block;
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

