# twu

RESTful API 设计

user
```
创建用户：POST /api/users
获取用户信息：GET /api/user-info
用户登陆：GET /api/users
```

menu
```
获取菜单：GET /api/menus
获取欢迎信息：GET /api/welcome-info
```

book
```
创建书籍：POST /api/books
获取书籍列表：GET /api/books
```

bookRecord
```
创建书籍记录（checkout）POST /api/book-records
修改书籍记录（return）PUT /api/book-records/{bookRecordId}
```

movie
```
创建电影：POST /api/movies
获取电影列表：GET /api/movies
```

movieRecord
```
创建电影记录（checkout）POST /api/movie-records
修改电影记录（return）PUT  /api/movie-records/{movieRecordId}
```

