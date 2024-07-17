import axios from "axios";
import { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";

export default function BoardDetail() {
  const [board, setBoard] = useState({});

  const [title, setTitle] = useState("");
  const [contents, setContents] = useState("");

  const { boardIdx } = useParams();

  const navigate = useNavigate();

  const listButtonClick = (e) => {
    e.preventDefault();
    navigate("/"); // 또는 navigate('/list') 또는 navigate(-1)
  };
  const updateButtonClick = (e) => {
    e.preventDefault();

    axios
      .put(`http://localhost:8080/api/board/${boardIdx}`, { title, contents })
      .then((res) => {
        res && res.status === 200 && navigate("/");
      })
      .catch((err) => console.log(err));
  };
  const deleteButtonClick = (e) => {
    e.preventDefault();

    axios
      .delete(`http://localhost:8080/api/board/${boardIdx}`)
      .then((res) => {
        res && res.status === 200 && navigate("/");
      })
      .catch((err) => console.log(err));
  };

  useEffect(() => {
    axios
      .get(`http://localhost:8080/api/board/${boardIdx}`)
      .then((res) => {
        res && res.data && setBoard(res.data);
        setTitle(res.data.title);
        setContents(res.data.contents);
      })
      .catch((err) => console.log(err));
  }, []);

  return (
    <>
      <div className="container">
        <h2>게시판 상세</h2>
        <form id="frm" method="post">
          <input type="hidden" id="boardIdx" name="boardIdx" />

          <table className="board_detail">
            <colgroup>
              <col width="15%" />
              <col width="*" />
              <col width="15%" />
              <col width="35%" />
            </colgroup>
            <tbody>
              <tr>
                <th scope="row">글 번호</th>
                <td>{board.boardIdx}</td>
                <th scope="row">조회수</th>
                <td>{board.hitCnt}</td>
              </tr>
              <tr>
                <th scope="row">작성자</th>
                <td>{board.creatorId}</td>
                <th scope="row">작성일</th>
                <td>{board.createdDatetime}</td>
              </tr>
              <tr>
                <th scope="row">제목</th>
                <td colSpan="3">
                  <input
                    type="text"
                    id="title"
                    name="title"
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                  />
                </td>
              </tr>
              <tr>
                <td colSpan="4">
                  <textarea
                    id="contents"
                    name="contents"
                    value={contents}
                    onChange={(e) => setContents(e.target.value)}
                  ></textarea>
                </td>
              </tr>
            </tbody>
          </table>
        </form>

        <div className="file_list">
          {board.fileInfoList &&
            board.fileInfoList.map((fileInfo) => (
              <p>
                {fileInfo.originalFileName} ({fileInfo.fileSize}kb)
              </p>
            ))}
        </div>

        <input
          type="button"
          id="list"
          className="btn"
          value="목록으로"
          onClick={listButtonClick}
        />
        <input
          type="button"
          id="update"
          className="btn"
          value="수정하기"
          onClick={updateButtonClick}
        />
        <input
          type="button"
          id="delete"
          className="btn"
          value="삭제하기"
          onClick={deleteButtonClick}
        />

        {/*
                <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
                <script>
                    $(function() {
                        $('#list').on('click', function() {
                            location.href = 'openBoardList.do';
                        });
                        $('#update').on('click', function() {
                            let frm = $('#frm')[0];
                            frm.action = "updateBoard.do";
                            frm.submit();
                        });
                        $('#delete').on('click', function() {
                            let frm = $('#frm')[0];
                            frm.action = "deleteBoard.do";
                            frm.submit();
                        });
                    });
                </script>			
                */}
      </div>
    </>
  );
}
