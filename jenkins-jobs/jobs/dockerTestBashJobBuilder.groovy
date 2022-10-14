pipelineJob('Test-Bash') {
    description('It tries to run docker commands inside a local container')
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/Robinthatdoesnotsuck/Jenkins-DSL-test.git')
                    }
                }
                extensions {
                    branch('master')
                    wipeOutWorkspace()
                    changelogToBranch {
                        options {
                            compareRemote('origin')
                            compareTarget('master')
                        }
                    }
                }
            }
            scriptPath('jenkins-job/scripts/dockerTestBash.groovy')
        }
    }

    properties {

    }
}