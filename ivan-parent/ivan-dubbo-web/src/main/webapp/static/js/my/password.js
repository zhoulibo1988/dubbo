var passwordPage = {
    scroll: null,
    storage: window.localStorage,
    userId: pageLocalStorage.getItem("userid"),
    pageNo: 1,
    pageSizr: 10,
    init: function () {
        $(".checkDiv").click(function () {
            $("#isDefault").click();
        });
            $("#titleCenter").text("�༭���͵�ַ");
            $.M.get({
                method:"/receiver.jhtml?memberId=" + passwordPage.userId,
                success: function (data) {
                    if (data.returnValue != "") {
                        var passwordData = data.returnValue;
                        var passwordDetailId = pageLocalStorage.getItem("passwordDetailId");
                        for (var i = 0; i < passwordData.length; i++) {
                            if (Number(passwordDetailId) == Number(passwordData[i].id)) {
                                $("#areaId").val(passwordData[i].areaId);
                                $("#addrName").val(passwordData[i].consignee);
                                $("#addrMobile").val(passwordData[i].phone);
                                $("#addrDistrict").val(passwordData[i].areaName);
                                $("#addrZipcode").val(passwordData[i].zipCode);
                                $("#addrDetail").val(passwordData[i].password);
                                if (passwordData[i].isDefault == 1) {
                                    $("#isDefault").attr('checked', true);
                                } else {
                                    $("#isDefault").attr('checked', false);
                                }
                                return;
                            }
                        }

                    }

                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                }
            });
    },
    checkPassword: function () {
        var str = "";
        if ($.trim($("#oldPassword").val()) == "") {
            str += ",������";
        }
        if ($.trim($("#newPassword").val()) == "") {
            str += ",������";
        }
        if ($.trim($("#reNewPassword").val()) == "") {
            str += ",�ٴ���������";
        }

        if (str != "") {
            str += "����Ϊ��";
            passwordPage.showMessages(str.substr(1));
        }
        else {
            if ($.trim($("#newPassword").val()) !== $.trim($("#reNewPassword").val())) {
                passwordPage.showMessages("�������������벻һ��");
            }else{
                this.saveValues();
            }
        }

    },
    saveValues: function () {
        var datas = {};
        datas.currentPassword = $.trim($("#oldPassword").val());
        datas.password = $.trim($("#newPassword").val());
        datas.memberId = passwordPage.userId;
        $.M.post({
            method: "/auth/updatePassword.jhtml?" + $.param(datas),
            success: function (data) {
                if (data.success) {
                    passwordPage.showMessages("�����ɹ�");
                    window.location.href = "setting.html";
                } else {
                    passwordPage.showMessages("����ʧ�ܣ�ʧ��ԭ��" + data.errorReason);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            }
        })

    },
    showMessages: function (messges) {
        $(".errorLabel").html(messges);
        $(".errorDiv").css("visibility", "visible");
        setTimeout('$(".errorDiv").css("visibility", "hidden")', 3000);
    },
    back: function () {
        window.location.href = "setting.html";
    }
};

$(document).bind("pageshow", function (e) {
    var id = e.target.id;
    if ("password_page" == id) {
        document.addEventListener('touchmove', function (e) {
            e.preventDefault();
        }, false);
        if (!passwordPage.scroll) {
            passwordPage.scroll = new iScroll("underpart_div_scroll", {
                useTransition: true,
                checkDOMChanges: true,
                hScrollbar: false,
                vScrollbar: false
            });
        }
        passwordPage.init();
    }
});
