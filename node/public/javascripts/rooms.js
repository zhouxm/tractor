$(document).ready(function() {
    // Login/register functions
    if ($('#registerlink').length) {
        $('#registerlink').on('click', function() {
            $('#registerpopup').show();
            $('#content').css('opacity', '0.5');
        });
        $('#registercancel').on('click', function() {
            $('#registerpopup').hide();
            $('#content').css('opacity', 1);
        });
        $('#registerbutton').on('click', function() {
            if ($('#registerpassword').val() != $('#registerconfirm').val()) {
                $('#registeralert').text('Your passwords do not match.');
            } else {
                $('#registerloading').show();
                $.post('/register', {
                    username: $('#registerusername').val(),
                    email: $('#registeremail').val(),
                    password: $('#registerpassword').val()
                }, function(data) {
                    if (data.error) {
                        $('#registeralert').text(data.error);
                        $('#registerloading').hide();
                    } else {
                        $('#registerloading').text('Registration successful.');
                        $('#registerbutton').hide();
                        $('#registercancel').text('Close');
                    }
                });
            }
        });
    } else {
        $('#profilelink').on('click', function() {
            $('#profilepopup').show();
            $('#content').css('opacity', '0.5');
        });
        $('#profileclose').on('click', function() {
            $('#profilepopup').hide();
            $('#content').css('opacity', 1);
        });
        $('#logout').on('click', function() {
            window.location.href='/logout';
        });
    }

    // Create/remove room functions
    var socket = io.connect('http://' + window.location.host);
    socket.on('rooms', function(data) {
        var html = '';
        for (var i = 0; i < data.length; i++) {
            var id = data[i].id;
            var owner = data[i].usernames.split(',')[0];
            var numMembers = data[i].usernames.split(',').length;
            html += '<li id="room' + id + 'link" class="link">' +
                data[i].roomname +
                '<span id="room' + id + 'info" class="info roominfo">' +
                'Owner: ' + owner + '<br/>' +
                'Num people: ' + numMembers + '<br/>' +
                'Status: ' + data[i].status + '<br/>' +
                '<span id="room' + id + 'join" class="blue button join">join</span>' +
                '</span>' +
                '<style>' +
                '#room' + id + 'link:hover #room' + id + 'info {' +
                    'display: block;' +
                '}' +
                '</style>' +
                '</li>';
        }
        $('#roomsul').html(html);
    });
    socket.on('removeroom', function(data) {
        $('#room' + data.id + 'link').remove();
    });

    $('#roomcreate').on('click', function() {
        $('#createpopup').show();
        $('#content').css('opacity', '0.5');
        $('#createclose').on('click', function() {
            $('#createpopup').hide();
            $('#content').css('opacity', 1);
        });
        $('#createbutton').on('click', function() {
            $('#createloading').show();
            $.post('/createroom', {roomname: $('#createroomname').val()},
                function(data) {
                    if (data.error) {
                        $('#createalert').text(data.error);
                    } else {
                        $('#createloading').hide();
                        $('#createpopup').hide();
                        $('#content').css('opacity', 1);
                    }
                });
        });
    });
});