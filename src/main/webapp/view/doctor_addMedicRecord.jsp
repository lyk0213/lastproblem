<%--
  Created by IntelliJ IDEA.
  User: lu97940467
  Date: 2021/4/13
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>进行病例的添加</title>
    <link rel="stylesheet" href="../static/layui/css/layui.css">
    <script src="../static/js/jquery-3.5.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="../static/js/jquery.cookie.js" type="text/javascript" charset="utf-8"></script>
    <script src="../static/layui/layui.js"></script>
    <script src="../static/js/doctorconfig.js" type="text/javascript"
            charset="utf-8"></script>
</head>
<body>

<form class="layui-form"  action=""  lay-filter="form1">
    <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素  form1进行下方ajax中的取值判断-->
    <!-- 第一个信息将sid进行影藏 -->
    <input type="text" name="did" hidden="hidden" />

    <div class="layui-form-item">
        <label class="layui-form-label">医生姓名</label>
        <div class="layui-input-block">
            <input type="text" name="docName" lay-verify="docName" class="layui-input" disabled="" title="不允许修改">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">账号名</label>
        <div class="layui-input-block">
            <input type="text" name="docNum" id="docNum" class="layui-input" disabled="" title="不允许修改">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">登录密码</label>
        <div class="layui-input-block">
            <input type="password" name="docPwd" class="layui-input" lay-verify="docPwd" placeholder="不修改则不填">
        </div>
    </div>
    <!--    可以改，需要在controller中进行查找并且保持原样-->

    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="radio" name="docSex" value="男" title="男">
            <input type="radio" name="docSex" value="女" title="女" >
            <!-- value传出的数值 -->
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">医师等级</label>
        <div class="layui-input-block">
            <input type="text" name="docLevel" class="layui-input" lay-verify="docLevel" disabled="" title="不允许修改">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">当前职位</label>
        <div class="layui-input-block">
            <input type="text" name="docPosition" class="layui-input" lay-verify="docPosition" disabled="" title="不允许修改">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">提交修改</button>
        </div>
    </div>
</form>



</body>
</html>
