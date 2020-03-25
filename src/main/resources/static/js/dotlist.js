$(function () {
    load(getProjectName()+"/tDot/getPage?pageNum=1&condition=")

    $(".searchBtn").click(function (event) {
        event.preventDefault();
        load(getProjectName()+"/tDot/getPage?pageNum=1&condition="+$(".condition").val());
    });

    $(".firAndEnd").click(function (e) {
        e.preventDefault();
        load($(this).attr("href"));
    });
});

function load(url) {
    let condition = url.substring(url.indexOf("condition=")+10,url.length);
    $.getJSON(url,null,function(res) {
        setTbody(res.list);
        setPageBtn(res,condition);
    });
}

/**
 * 设置tbody
 * @param list
 */
function setTbody(list) {
    //清除旧内容
    $("tbody").html("");
    //添加新内容
    $.each(list, function (i, item) {
        var content = "<tr>" +
            "<td>" + item.dotName + "</td>" +
            "<td>" + (item.dotPhone==null?'未知':item.dotPhone) + "</td>" +
            "<td>" + (item.dotCity==null?'未知':item.dotCity) + "</td>" +
            "<td>" + (item.dotAddress==null?'未知':item.dotAddress) + "</td>" +
            "<td>" +
            "<a href=\"" + getProjectName() + "/tDot/toModify?dotId=" + item.dotId + "\" class=\"btn btn-info btn-xs\">" +
            "<span class=\"glyphicon glyphicon-edit\"></span> 修改" +
            "</a>" +
            "<a href=\"" + getProjectName() + "/tDot/delete?dotId=" + item.dotId + "\" class=\"btn btn-danger btn-xs delBtn\">" +
            "<span class=\"glyphicon glyphicon-remove\"></span> 删除" +
            "</a>" +
            "</td>" +
            "</tr>";
        $("tbody").append(content);
        $(".delBtn").unbind("click");
        $(".delBtn").click(function (event) {
            event.preventDefault();
            if (confirm("是否确定移出该用户")){
                const url = $(this).attr("href");
                const that = $(this);
                $.get(url,function (flag) {
                    if (flag){
                        alert("移除成功");
                        const url = $("#currentPage").attr("data-url");
                        load(url);
                    }else{
                        alert("移除失败");
                    }
                })
            }
        })
    });
}

/**
 * 设置分页
 */
function setPageBtn(page, condition) {
    var pageNum = page.pageNum;
    var totalPage = page.totalPage;
    var count = page.count;
    const url = getProjectName() + "/tDot/getPage?pageNum=";
    //清除旧数字页
    $(".numPage").remove();
    $(".prevPage").parent().remove();
    $(".nextPage").parent().remove();
    //设置数字页
    var content = "";
    for (var i = (pageNum < 4 ? 1 : pageNum); i <= (pageNum + 3 > totalPage ? totalPage : pageNum + 3); i++) {
        if (i != pageNum)
            content += "<li class='numPage'>\n" +
                "<a class=\"pageBtn\" href=\"" + url + i + "&condition="+condition+"\">" + i + "</a>\n" +
                "</li>\n";
        else
            content += "<li class='numPage'>\n" +
                "<span style=\"color: grey\" id=\"currentPage\" data-url=\""+url+i+"&condition="+condition+"\">" + i + "</span>\n" +
                "</li>\n";
    }
    $(".firstPage").parent().after(content);
    //设置前一页和后一页
    if (pageNum != 1) {
        var prevContent = "<li>\n" +
            "<a href=\"" + url + (pageNum - 1) + "&condition="+condition+"\" aria-label=\"Previous\" class=\"pageBtn prevPage\">\n" +
            "<span aria-hidden=\"true\">&laquo;</span>\n" +
            "</a>\n" +
            "</li>";
        $(".firstPage").parent().after(prevContent);
    }
    if (pageNum < totalPage) {
        var nextContent = "<li>\n" +
            "<a href=\"" + url + (pageNum + 1) + "&condition="+condition+ "\" aria-label=\"Next\" class=\"pageBtn nextPage\">\n" +
            "<span aria-hidden=\"true\">&raquo;</span>\n" +
            "</a>\n" +
            "</li>";
        $(".lastPage").parent().before(nextContent);
    }
    //设置首页与末页
    $(".firstPage").attr("href", url+1+"&condition="+condition);
    $(".lastPage").attr("href", url + totalPage + "&condition="+condition);
    //设置总记录条数
    $("#total").html("总记录条数:" + count);
    //绑定新点击事件
    $(".pageBtn").click(function (e) {
        e.preventDefault();
        load($(this).attr("href"));
    });
}
