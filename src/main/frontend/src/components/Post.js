import React, {useEffect, useState} from 'react';
import {makeStyles} from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import {Button, Container, Paper} from '@material-ui/core';
import axios from 'axios'

const useStyles = makeStyles((theme) => ({
    root: {
        '& > *': {
            margin: theme.spacing(1),
        },
    },
}));

const Post = () => {
    const paperStyle = {padding: '1px 10px', width: 500, margin: "10px auto"}
    const [posts, setPosts] = useState([])
    const [title, setTitle] = useState('')
    const [text, setText] = useState('')
    const classes = useStyles();

    const request = axios.create({
        baseURL: "http://localhost:8081"
    })

    useEffect(() => {
        getPosts()
    }, []);

    const getPosts = () => {
        request.get("/posts")
            .then((response) => {
                setPosts(response.data)
                console.log(response.data)
            });
    }

    const addPost = () => {
        const post = {title, text}
         request.post("/posts/add", post)
            .then((response) => {
                console.log('POST: post is added', response)
            })
        return getPosts()
    };

    const deletePost = (id) => {
        request.post(`/posts/delete/${id}`)
            .then(response => response.data);
        return getPosts()
    };

    const deleteAllPosts = () => {
        return request.post("http://localhost:8081/posts/deleteAll");
    }

    return (
        <Container>
            <Paper elevation={24} style={paperStyle}>
                <h1 style={{color: "blue"}}><u>Add Post</u></h1>
                <form className={classes.root} noValidate autoComplete="off">
                    <TextField id="outlined-basic"
                               label="Post title"
                               variant="standard" fullWidth
                               value={title}
                               onChange={(e) => setTitle(e.target.value)}
                    />
                    <TextField id="outlined-basic"
                               label="Post text"
                               variant="standard" fullWidth
                               value={text}
                               onChange={(e) => setText(e.target.value)}/>
                    <Button type={"submit"}
                            variant="contained"
                            color="default"
                            onClick={addPost}
                    >Создать пост</Button><br/>
                    <Button type={"submit"}
                            variant="contained"
                            color="secondary"
                            onClick={deleteAllPosts}
                    >Удалить всё</
                        Button>
                </form>
            </Paper>
            <h1>Posts</h1>
            <Paper elevation={24} style={paperStyle}>
                {posts.map(posts => (
                    <Paper elevation={24} style={{margin: "10px", padding: "10px", textAlign: "left"}} key={posts.id}>
                        Title: {posts.title}<br/>
                        Text: {posts.text}<br/>
                        Updated: {posts.time}<br/>
                        <Button type={"submit"}
                                size="small"
                                variant="contained"
                                color="primary"
                                onClick={() => deletePost(posts.id)}
                        >Удалить</Button>
                    </Paper>
                ))
                }
            </Paper>
        </Container>
    );
}
export default Post
