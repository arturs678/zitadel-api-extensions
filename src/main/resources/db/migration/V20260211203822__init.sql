CREATE TABLE idp_links
(
    id            uuid PRIMARY KEY,
    user_id       text    NOT NULL,
    idp_id        text    NOT NULL,
    idp_user_id   text    NOT NULL,
    idp_user_name text    NOT NULL,
    version       integer NOT NULL
);

CREATE UNIQUE INDEX idp_links_idp_id_idp_user_id_idx ON idp_links (idp_id, idp_user_id);
