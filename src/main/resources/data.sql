insert into subject(id, name) values (1, '수학');
insert into subject(id, name) values (2, '국어');
insert into subject(id, name) values (3, '영어');
insert into professor (id, name, subject_id) values (1, '일교수', 1);
insert into professor (id, name, subject_id) values (2, '이교수', 2);
insert into professor (id, name, subject_id) values (3, '삼교수', 3);
insert into professor (id, name) values (4, '사교수');
insert into professor (id, name) values (5, '오교수');
insert into student (id, name, professor_id) values (1, '일학생', 1);
insert into student (id, name, professor_id) values (2, '이학생', 2);
insert into student (id, name, professor_id) values (3, '삼학생', 3);
insert into student (id, name, professor_id) values (4, '사학생', 1);
insert into student (id, name, professor_id) values (5, '오학생', 2);
insert into student (id, name, professor_id) values (6, '육학생', 3);
insert into student (id, name, professor_id) values (7, '칠학생', 4);
insert into student (id, name, professor_id) values (8, '팔학생', 1);
insert into student (id, name, professor_id) values (9, '구학생', 2);
insert into student (id, name, professor_id) values (10, '십학생', 3);
insert into student (id, name, professor_id) values (11, '십일생', 4);
insert into student (id, name, professor_id) values (12, '십이생', 5);
insert into student (id, name, professor_id) values (13, '십삼생', 2);
insert into student (id, name, professor_id) values (14, '십사생', 3);
insert into student (id, name, professor_id) values (15, '십오생', 4);
insert into student (id, name, professor_id) values (16, '십육생', 5);
insert into student_subject (student_id, subject_id) values (1, 1);
insert into student_subject (student_id, subject_id) values (1, 2);
insert into student_subject (student_id, subject_id) values (1, 3);
insert into student_subject (student_id, subject_id) values (2, 2);
insert into student_subject (student_id, subject_id) values (2, 3);
insert into student_subject (student_id, subject_id) values (3, 3);
insert into student_subject (student_id, subject_id) values (4, 1);
insert into student_subject (student_id, subject_id) values (4, 3);
insert into student_subject (student_id, subject_id) values (5, 1);
insert into student_subject (student_id, subject_id) values (5, 2);
insert into student_subject (student_id, subject_id) values (6, 1);
insert into student_subject (student_id, subject_id) values (8, 1);
insert into student_subject (student_id, subject_id) values (8, 3);
insert into student_subject (student_id, subject_id) values (9, 2);
insert into student_subject (student_id, subject_id) values (9, 3);
insert into student_subject (student_id, subject_id) values (10, 1);
insert into student_subject (student_id, subject_id) values (11, 1);
insert into student_subject (student_id, subject_id) values (11, 2);
insert into student_subject (student_id, subject_id) values (12, 1);
insert into student_subject (student_id, subject_id) values (12, 2);
insert into student_subject (student_id, subject_id) values (12, 3);
insert into student_subject (student_id, subject_id) values (13, 2);
insert into student_subject (student_id, subject_id) values (13, 3);
insert into student_subject (student_id, subject_id) values (14, 2);
insert into student_subject (student_id, subject_id) values (15, 3);
insert into student_subject (student_id, subject_id) values (16, 1);
insert into student_subject (student_id, subject_id) values (16, 3);
