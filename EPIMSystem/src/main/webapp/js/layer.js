/**
 * 通用的js前后端交互代码
 * 依赖layer.js
 * ajaxPost处理本页提交的js请求，不对返回结果做处理，只 '显示' 或者 '刷新页面' 或者 '跳转'
 * ajaxGet同上，但是没有data选项，如果有数据发送，跟随在url中
 * ajaxFile表单文件提交
 * ajaxForm表单提交
 * 表单提交的时候，需要提交的选项用class="send-item"标识，默认必填项。
 * 内容提示先获取data-msg的值，如果没有，获取palceholder的值。
 * 如果不是必填项，需要添加no-required，即class="send-item no-required"
 * 表单带有文件上传的时候有两种，一种是先上传文件，获得返回值即文件的存储路径，提交表单的时候提交文件存储路径，请使用ajaxForm
 * 如果文件内容跟随表单提交，请使用ajaxFile
 */
function ajaxPost(url, data){
    layer.closeAll('msg');
    layer.load();
    $.ajax({
        url: url,
        data: data,
        type: 'post',
        dataType: 'json',
        success: function(res){
            success(res);
        }
    })
}
function ajaxGet(url){
    layer.closeAll('msg');
    layer.load();
    $.ajax({
        url: url,
        type: 'get',
        dataType: 'json',
        success: function(res){
            success(res);
        }
    })
}
function ajaxFile($form,tips){
    layer.closeAll('msg');
    var url = $form.prop('action');
    var data = new FormData();
    var status = true;
    $form.find('.send-item').each(function(index,elem){
        if(!status){
            return false;
        }
        var name = elem.name;
        var value = elem.value;
        var type = elem.type;
        var msg = $(elem).data('msg') || elem.placeholder;
        if(type != 'password'){
            value = value.trim();
        }
        if(elem.type == 'checkbox' && !elem.checked){
            if(tips){
                layer.tips(msg, $(elem), {tips: 2, time: 1e3});
            }else{
                layer.msg(msg, {icon: 0, time: 1e3, maxWidth: 260});
            }
            status = false;
        }
        if(elem.type == 'file' && !elem.files[0]){
            if(tips){
                layer.tips(msg, $(elem).parent(), {tips: 2, time: 1e3});
            }else{
                layer.msg(msg, {icon: 0, time: 1e3, maxWidth: 260});
            }
            status = false;
        }
        if(status && value == '' && !$(this).hasClass('no-required')){
            if(tips){
                layer.tips(msg, $(elem), {tips: 2, time: 1e3});
            }else{
                layer.msg(msg, {icon: 0, time: 1e3, maxWidth: 260});
            }
            status = false;
        }
        if(elem.type == 'file'){
            var file = elem.files[0];
            data.append('upload[]', file, file.name);
        }else{
            data.append(name,value);
        }
    });
    if(!status){
        return false;
    }
    layer.load();
    $.ajax({
        url: url,
        data: data,
        type: 'post',
        processData: false,
        contentType: false,
        dataType: 'json',
        success: function(res){
            success(res);
        }
    })
}
function ajaxForm($form,tips){
    var url = $form.prop('action');
    var data = {};
    var status = true;
    $form.find('.send-item').each(function(index,elem){
        if(!status){
            return false;
        }
        var name = elem.name;
        var value = elem.value;
        var type = elem.type;
        var msg = $(elem).data('msg') || elem.placeholder;
        if(type != 'password'){
            value = value.trim();
        }
        if(elem.type == 'checkbox' && !elem.checked){
            if(tips){
                layer.tips(msg, $(elem), {tips: 2, time: 1e3});
            }else{
                layer.msg(msg, {icon: 0, time: 1e3, maxWidth: 260});
            }
            status = false;
        }
        if(status && value == '' && !$(this).hasClass('no-required')){
            if(tips){
                layer.tips(msg, $(elem), {tips: 2, time: 1e3});
            }else{
                layer.msg(msg, {icon: 0, time: 1e3, maxWidth: 260});
            }
            status = false;
        }
        data[name] = value;
    });

    if(!status){
        return false;
    }
    layer.load();
    $.ajax({
        url: url,
        data: data,
        type: 'post',
        dataType: 'json',
        success: function(res){
            success(res);
        }
    })
}

function success(res){
    /**
     * @res = {status: 1, msg: '', url: ''};
     * @status => 0 失败
     * @status => 1 成功
     * @msg => '提示'
     * @url => 'reload' 页面需要刷新
     * @url => '/base' 页面跳转到'/base'
     */
    layer.closeAll('loading');
    if(res.msg){
        layer.msg(res.msg, {icon: res.status, time: 2e3, maxWidth: 260}, function(){
            if(res.url == 'reload'){
                window.location.reload();
                return false;
            }
            if(res.url){
                window.location.href = res.url;
            }
        });
    }else{
        if(res.url == 'reload'){
            window.location.reload();
            return false;
        }
        if(res.url){
            window.location.href = res.url;
        }
    }
}