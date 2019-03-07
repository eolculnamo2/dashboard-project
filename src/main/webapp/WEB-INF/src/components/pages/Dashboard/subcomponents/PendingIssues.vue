<template>
    <div class="d-box-wrap pi-wrap">
        <div class="d-heading">
            <div>Pending Issues</div>
            <button class="d-add-edit">Add/Edit</button>
        </div>
        <div class="pi-body">
            <div class="pi-issue"
                v-for="(issue,i) in issues"
                :key="'issue'+i">
                <div>
                    <h3 class="pi-issue-heading"
                        :class="issue.solved ? 'pi-issue-heading--solved' : 'pi-issue-heading--unsolved'">{{issue.name}}</h3>
                    <div class="pi-issue-assigned">Assigned To: {{issue.assignedTo}}</div>
                </div>
                <button class="pi-issue-btn"
                        :class="{'pi-issue-btn--solved' : issue.solved}">{{solvedText(issue.solved)}}</button>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    data() {
        return {
            issues: [
                {
                    name: "JIRA-123",
                    assignedTo: "Rob",
                    solved: false
                },
                {
                    name: "JIRA-323",
                    assignedTo: "Rob",
                    solved: true
                }
            ]
        }
    },
    methods: {
        solvedText(isSolved) {
            return isSolved ? "Solved" : "Solve";
        }
    }
}
</script>

<style lang="scss">
    @import './boxes.scss';
    .pi-wrap {
        max-width: 610px;
    }
    .pi-body {
        padding: 1.8rem;
    }
    .pi-issue {
        display: flex;
        justify-content: space-between;
        align-items: center;
        border: 1px solid $dark4;
        padding: 1rem;
        margin-top: .5rem;
    }
    .pi-issue-heading {
        margin: 0 0 .5rem 0;
        color: $dark1;
        font-weight: 500;
        &--unsolved {
            &:before {
                content: "";
                background: url("../../../../images/unsolved-icon.png") center center no-repeat;
                padding: .75rem;
                margin-right: .5rem;
            }
        }
        &--solved {
            &:before {
                content: "";
                background: url("../../../../images/solved-icon.png") center center no-repeat;
                padding: .75rem;
                margin-right: .5rem;
            }
        }
    }
    .pi-issue-assigned {
        color: $dark4;
        padding-left: 2rem;
    }
    .pi-issue-btn {
        font-size: 1rem;
        background: white;
        border: 1px solid $dark4;
        border-radius: 20px;
        padding: .2rem 1rem;
        outline: none;
        cursor: pointer;
        &--solved {
            background: $gray1;
        }
    }
</style>
