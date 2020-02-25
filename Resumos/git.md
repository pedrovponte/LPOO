# GIT COMMANDS

| Command | Description |
| :----------: | :-----------: |
| cd directory | Change directory |
| git init | Initialize the git repository |
| ls -la | List directory contents |
| git status (-s) | Show the files status |
| echo "out/" >> .gitignore | Appends out to the .gitignore file |
| git add *filename* | Add files to the staging area |
| git add --all | Add all files to the staging area |
| git commit -m "*message*" | Commit the new version |
| git log | See the list of all commits |
| git log --oneline -n | See a cleaner list of last *n* commits |
| git log -n -p | Shows the difference (the patch output) in each last *n* commits |
| git rm *filename* | Delete file and add that change to the staging area |
| git diff *filename* | Check changes in a file |
| git branch | Shows branch that we're currently working on |
| git branch *branchname* | Create a new branch with name *branchname* |
| git checkout *branchname* | Change to the *branchname* branch |
| git checkout -b *branchname* | Branch and checkout the branch with name *branchname* |
| git merge *branchname* | Merge branches master and *branchname* **(IN MASTER BRANCH)** |
| git branch -d *branchname* | Delete *branchname* branch |
| git remote add origin git@github.com:yourusername/repository.git | Add remote |
| git remote -v | List the remotes of the project |
| git push origin master | Explicity say what remote and remote branch we want to push to |
| git branch -u origin/master | Connect local current branch to the master branch on the origin remote |
| git push | Push the local repository to the remote |
| git fetch | Fetch the changes to our local repository |
| git merge origin/master | After do fetch, it's necessary to merge |
| git pull | The same as git fetch + git merge origin/master |
| git clone git@github.com:yourusername/repository.git | Clone the repository |
| git checkout -- *filename* | Revert changes in a file |
| git reset --hard | Revert changes on all files |
| git reset --hard *commit-id* | Revert changes to a certain commit |
| git revert *commit-id* | Revert a previous commit |
 