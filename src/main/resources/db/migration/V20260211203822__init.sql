CREATE TABLE idp_links
(
    id                   uuid PRIMARY KEY,
    idp_id               text    NOT NULL,
    idp_user_id          text    NOT NULL,
    idp_user_name        text    NOT NULL,
    int_internal_user_id text    NOT NULL,
    version              integer NOT NULL
);

CREATE UNIQUE INDEX idp_links_idp_id_idp_user_id_idx ON idp_links (idp_id, idp_user_id);
