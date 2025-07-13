def build() {
    echo "PRINTING VAR -> ${env.myVar}"
    echo "Building branch: ${params.BRANCH_NAME}"
}

def test() {
    echo "Testing enabled: ${params.executeTests}"
    echo 'Testing...'
}

def deploy() {
    withCredentials([
        usernamePassword(credentialsId: 'server-credentials', usernameVariable: 'USER', passwordVariable: 'PASSWORD')
    ]) {
        echo "Deploying with user: ${USER} and password: ${PASSWORD}"
    }
    echo "Deploying ${params.VERSION}..."
}

return this