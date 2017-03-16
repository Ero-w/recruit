/**********************************************************
*
*后台管理设计-个人应用
*
**********************************************************/

var onlyOpenTitle="欢迎使用";//不允许关闭的标签的标题

//页面初始化
window.onload=function() { 
    $("#loading-mask").fadeOut();
};

//页面初始化
$(function(){
	
    initLeftMenu();
    tabClose();
    tabCloseEvent();
    
    //选择TAB时刷新内容
    /*$("#tabs").tabs({
        onSelect: function(title) { 
            var currTab = $("#tabs").tabs("getTab",title);
            var iframe = $(currTab.panel("options").content);
            
            var src = iframe.attr("src");
            if(src) { 
                $("#tabs").tabs("update",{tab:currTab,options:{content:createFrame(src)}});
            }
        }
    });*/
});

function initLeftMenu() { //初始化左侧菜单
    $("#nav").accordion({animate:false,fit:true,border:false});
    
    var selectedPanelname = "";
    
    $.each(_menus.menus,function(i,n) { 
        var menulist = "";
        menulist += "<ul class=\"navlist\">";
        $.each(n.menus,function(j,o) { 
            menulist += "<li><div ><a ref=\"" + o.menuid + "\" href=\"javascript:void(0);\" rel=\"" + o.url + "\"><span class=\"icon " + o.icon + "\">&nbsp;</span><span class=\"nav\">" + o.menuname + "</span></a></div>";
            if(o.child && o.child.length>0) { //li.find("div").addClass("icon-arrow");
                menulist += "<ul class=\"third_ul\">";
                $.each(o.child,function(k,p) { 
                    menulist += "<li><div><a ref=\"" + p.menuid + "\" href=\"javascript:void(0);\" rel=\"" + p.url + "\"><span class=\"icon " + p.icon + "\">&nbsp;</span><span class=\"nav\">" + p.menuname + "</span></a></div></li>";
                });
                menulist += "</ul>";
            }
            menulist += "</li>";
        });
        menulist += "</ul>";
        
        $("#nav").accordion("add", { 
            title:n.menuname,
            content:menulist,
            border:false,
            iconCls:"icon " + n.icon
        });
        
        if(i==0) { 
            selectedPanelname = n.menuname;
        }
    });
    
    $("#nav").accordion("select",selectedPanelname);
    
    $(".navlist li a").click(function() { 
        var tabTitle = $(this).children(".nav").text();
		
        var url = $(this).attr("rel");
        var menuid = $(this).attr("ref");
        var icon = $(this).find(".icon").attr("class");
        
        var third = find(menuid);
        if(third && third.child && third.child.length>0) { 
            $(".third_ul").slideUp();
            var ul = $(this).parent().next();
            if(ul.is(":hidden")) { 
                ul.slideDown();
            } else { 
                ul.slideUp();
            }
        } else { 
            addTab(tabTitle,url,icon);
            $(".navlist li div").removeClass("selected");
            $(this).parent().addClass("selected");
        }
    }).hover(function(){
        $(this).parent().addClass("hover");
    },function(){
        $(this).parent().removeClass("hover");
    });
	
    //设置默认选中项
    //var panels = $("#nav").accordion("panels");
    //var tab = panels[0].panel("options").title;
    //$("#nav").accordion("select",tab);
    
    //$("#nav").accordion({animate:true,fit:true,border:false});//设置动画效果
}

$.accordionSelectItem=function(jqObject) { //选择左侧菜单效果修正
    var indexSelect=-1;
    var list = $("#nav").accordion("panels");
    $.each(list,function(index,item) { 
        var myObject=item.parent().children("div:first");//alert(myObject.prop("outerHTML"));
        if (index==0) { //当前第一项
            myObject.css("border-top-width","0px");
            myObject.css("border-bottom-width","1px");
            if (myObject.prop("outerHTML")==jqObject.prop("outerHTML")) { //当前选中项
                indexSelect=index;//alert(myObject.prop("outerHTML")+"\r\n"+jqObject.prop("outerHTML"));
                myObject.css("border-top-width","0px");
                myObject.css("border-bottom-width","1px");
            }
        } else { //当前其它项
            if (myObject.prop("outerHTML")==jqObject.prop("outerHTML")) { //当前选中项
                indexSelect=index;//alert(myObject.prop("outerHTML")+"\r\n"+jqObject.prop("outerHTML"));
                myObject.css("border-top-width","0px");
                myObject.css("border-bottom-width","1px");
            } else if (indexSelect==-1) { //当前项之前
                myObject.css("border-top-width","0px");
                myObject.css("border-bottom-width","1px");
            } else { //当前项之后
                if (jqObject.attr("class").indexOf("accordion-header-selected")>0) { //当前项展开
                    myObject.css("border-top-width","1px");
                    myObject.css("border-bottom-width","0px");
                } else { //当前项缩回
                    myObject.css("border-top-width","0px");
                    myObject.css("border-bottom-width","1px");
                }
            }
        }
    });
}

function getIcon(menuid) { //获取左侧导航的图标
    var icon = "icon ";
    $.each(_menus.menus,function(i,n) { 
        $.each(n.menus,function(j,o) { 
            if(o.menuid == menuid) { 
                icon += o.icon;
            }
        });
    });
    return icon;
}

function find(menuid) { //查找菜单
    var obj=null;
    $.each(_menus.menus,function(i,n) { 
        $.each(n.menus,function(j,o) { 
            if(o.menuid == menuid) { 
                obj = o;
            }
        });
    });
    return obj;
}

function addTab(subtitle,url,icon) { //添加选项页
    if(!$("#tabs").tabs("exists",subtitle)) { 
        $("#tabs").tabs("add",{ 
            title:subtitle,
            content:createFrame(url),
            closable:true,
            icon:icon
        });
    } else { 
        $("#tabs").tabs("select",subtitle);
        $("#tabMenu-tabupdate").click();
    }
    tabClose();
}

function createFrame(url) { //新建框架页
    return "<iframe scrolling=\"auto\" frameborder=\"0\"  src=\"" + url + "\" style=\"width:100%;height:100%;\"></iframe>";
}

function tabClose() { //绑定选项事件
	/*双击关闭TAB选项卡*/
    $(".tabs-inner").dblclick(function() { 
        var subtitle = $(this).children(".tabs-closable").text();
        $("#tabs").tabs("close",subtitle);
    })
    /*为选项卡绑定右键*/
    $(".tabs-inner").bind("contextmenu",function(e) { 
        $("#tabMenu").menu("show", {left:e.pageX,top:e.pageY});
        
        var subtitle =$(this).children(".tabs-closable").text();
        
        $("#tabMenu").data("currtab",subtitle);
        $("#tabs").tabs("select",subtitle);
        return false;
    });
}

function tabCloseEvent() { //绑定右键菜单事件
    $("#tabMenu").menu({
        onClick:function(item) { 
            closeTab(item.id);
        }
    });
    return false;
}

function closeTab(action) { //选项菜单事件
    var alltabs = $("#tabs").tabs("tabs");
    var currentTab = $("#tabs").tabs("getSelected");
    var allTabtitle = [];
    $.each(alltabs,function(i,n) { 
        allTabtitle.push($(n).panel("options").title);
    });
    switch(action) { 
        case "refresh":
            var iframe = $(currentTab.panel("options").content);
            var src = iframe.attr("src");
            $("#tabs").tabs("update",{ 
                tab:currentTab,
                options:{content:createFrame(src)}
            });
            break;
        case "close":
            var currtab_title = currentTab.panel("options").title;
            $("#tabs").tabs("close",currtab_title);
            break;
        case "closeall":
            $.each(allTabtitle,function(i,n) { 
                if(n != onlyOpenTitle) { 
                    $("#tabs").tabs("close",n);
                }
            });
            break;
        case "closeother":
            var currtab_title = currentTab.panel("options").title;
            $.each(allTabtitle,function(i,n) { 
                if (n != currtab_title && n != onlyOpenTitle) { 
                    $("#tabs").tabs("close",n);
                }
            });
            break;
        case "closeright":
            var tabIndex = $("#tabs").tabs("getTabIndex",currentTab);
            if (tabIndex == alltabs.length - 1) { 
                return false;//alert("亲,后前边那个上头有人,咱惹不起哦!!");
            }
            $.each(allTabtitle,function(i,n) { 
                if (i > tabIndex) { 
                    if (n != onlyOpenTitle) { 
                        $("#tabs").tabs("close",n);
                    }
                }
            });
            break;
        case "closeleft":
            var tabIndex = $("#tabs").tabs("getTabIndex",currentTab);
            if (tabIndex == 1) { 
                return false;//alert("亲,前边那个上头有人,咱惹不起哦!");
            }
            $.each(allTabtitle,function(i,n) { 
                if (i < tabIndex) { 
                    if (n != onlyOpenTitle) { 
                        $("#tabs").tabs("close",n);
                    }
                }
            });
            break;
        case "exit":
            $("#closeMenu").menu("hide");
            break;
    }
}

//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
function msgShow(title, msgString, msgType) { 
    $.messager.alert(title, msgString, msgType);
}