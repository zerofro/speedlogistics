//获取项目名
function getProjectName() {
    var pathname = window.location.pathname;
    var projectName = pathname.substring(0, pathname.substr(1).indexOf('/') + 1);
    return projectName;
}
