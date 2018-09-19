$(function () {
    console.log("hello");
    var $button = $('form button');
    var $ul = $('#books');

    loadAll();

    $ul.on('click', 'span', function () {
        var $span = $(this);
        var bookId = $span.data('id');
        var $div = $span.next();
        $div.empty();

        $.ajax({
            url: 'http://localhost:8080/books/loadById/' + bookId,
            method: 'GET',
            success: function (book) {
                var info = [
                    book.author,
                    book.isbn,
                    book.publisher,
                    book.type
                ];
                info.forEach(function (detail) {
                    var $p = $('<p>').text(detail);
                    $div.append($p);
                });
                $div.slideToggle();
            }
        })
    });

    $button.on('click', function (event) {
        event.preventDefault();
        var data = {
            'isbn': $('[name="isbn"]').val(),
            'title': $('[name="title"]').val(),
            'author': $('[name="author"]').val(),
            'publisher': $('[name="publisher"]').val(),
            'type': $('[name="type"]').val()
        };

        $.ajax({
            url: 'http://localhost:8080/books/addBook',
            dataType: 'json',
            contentType : 'application/json',
            data: JSON.stringify(data),
            method: 'POST'
        });
        success: loadAll();
    });

    $ul.on('click', 'button', function () {
        var id = $(this).prev().prev().attr('data-id');
        $.ajax({
            url: 'http://localhost:8080/books/delete/' + id,
            method: 'DELETE',
            success: function () {removeLis(); loadAll()}
        });
    });

    function loadAll() {
        removeLis();
        $.ajax({
            url: 'http://localhost:8080/books/loadAll',
            method: 'GET',
            success: function (response) {
                response.forEach(function (book) {
                    var $li = $('<li>');
                    var $span = $('<span>').text(book.title).attr('data-id', book.id);
                    var $deleteButton = $("<button>", {type: 'submit', name: 'usuń'}).text('usuń');
                    var $div = $('<div>').css('display', 'none');
                    $li.append($span);
                    $li.append($div);
                    $li.append($deleteButton);
                    $ul.append($li);
                })
            }
        });
    }

    function removeLis() {
        var $lis = $ul.find('li');
        $lis.each(function () {
            $(this).remove();
        });
    }
});



// function request(onDone, bookId, method, data, dataType) {
//     var BASE_URL = 'http://localhost:8282/books/'
//     var url = bookId ?
//         BASE_URL + bookId :
//         BASE_URL
//     $.ajax({
//         url: url,
//         method: method || 'GET',
//         data: data || null,
//         dataType: dataType || null,
//         success: onDone
//     })
// }function getBooks(onDone) {
//     request(onDone)
// }function getBook(bookId, onDone) {
//     request(onDone, bookId)
// }function addBook(data, onDone) {
//     request(onDone, null, 'POST', data)
// }function removeBook(bookId, onDone) {
//     $.ajax({
//         method: 'DELETE',
//     })
// }