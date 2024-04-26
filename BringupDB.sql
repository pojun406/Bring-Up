
        
CREATE TABLE advertisement
(
  advertisementindex INT         NOT NULL COMMENT '광고인덱스',
  index              INT         NOT NULL COMMENT '인덱스',
  advertisementimage VARCHAR     NULL     COMMENT '광고이미지',
  type               VARCHAR(30) NULL     COMMENT '광고타입(배너/프리미엄광고)',
  PRIMARY KEY (advertisementindex)
) COMMENT '광고';

CREATE TABLE applyCV
(
  index          NOT NULL,
  index  INT     NOT NULL COMMENT '인덱스번호',
  index  INT     NOT NULL COMMENT '인덱스',
  status VARCHAR NOT NULL COMMENT '합/불 여부',
  PRIMARY KEY (index)
) COMMENT '지원했던공고';

CREATE TABLE banerlank
(
  lank      VARCHAR(10) NOT NULL COMMENT '등급',
  lankprice INT         NOT NULL COMMENT '배너가격',
  oupputnum INT         NOT NULL COMMENT '출력횟수',
  PRIMARY KEY (lank)
) COMMENT '배너등급';

CREATE TABLE career
(
  index                    NOT NULL,
  userId       VARCHAR(8)  NOT NULL COMMENT '유저 아이디',
  careerstart  VARCHAR(30) NOT NULL COMMENT '시작경력',
  endstart     VARCHAR(30) NULL     COMMENT '끝경력',
  companyname  VARCHAR(30) NOT NULL COMMENT '회사이름',
  careerposion VARCHAR(30) NOT NULL COMMENT '직급',
  useremail    VARCHAR(20) NOT NULL COMMENT '유저 이메일',
  PRIMARY KEY (index)
) COMMENT '경력';

CREATE TABLE category
(
  index        INT         NOT NULL COMMENT '인덱스번호',
  manageremail VARCHAR     NOT NULL COMMENT '담당자 이메일',
  categoryname VARCHAR(20) NOT NULL COMMENT '직군 이름',
  PRIMARY KEY (index)
) COMMENT '직군';

CREATE TABLE company
(
  manageremail       VARCHAR     NOT NULL COMMENT '담당자 이메일',
  companyname        VARCHAR     NOT NULL COMMENT '회사 이름',
  companypassword    VARCHAR(20) NOT NULL COMMENT '회사 비밀번호',
  companycategory    VARCHAR(30) NOT NULL COMMENT '회사 구분',
  companyopendate    VARCHAR(30) NULL     COMMENT '개업 일자',
  companylicense     INT(30)     NOT NULL COMMENT '사업자 등록번호',
  companyname        VARCHAR(30) NOT NULL COMMENT '회사 이름',
  companyphonenumber VARCHAR(11) NULL     COMMENT '회사 전화번호',
  companyadress      VARCHAR(30) NOT NULL COMMENT '회사 주소',
  companycategory    VARCHAR(30) NOT NULL COMMENT '회사  카테고리',
  companycontent     TEXT        NOT NULL COMMENT '사업 내용',
  companywelfare     TEXT        NOT NULL COMMENT '기업 복리후생',
  companyvision      TEXT        NOT NULL COMMENT '기업 비전',
  companyhistroy     TEXT        NOT NULL COMMENT '기업 연혁',
  mastername         VARCHAR(10) NOT NULL COMMENT '대표 이름',
  managername        VARCHAR(10) NOT NULL COMMENT '담당자 이름',
  managerphonenumber VARCHAR(10) NOT NULL COMMENT '담당자 번호',
  companysize        INT         NOT NULL COMMENT '회사규모',
  companylogo        VARCHAR     NULL     COMMENT '회사로고',
  openCVkey          INT         NOT NULL DEFAULT 0 COMMENT '열람키갯수',
  PRIMARY KEY (manageremail)
) COMMENT '회사';

CREATE TABLE companybookmark
(
  companybookmarkindex INT         NOT NULL COMMENT '기업 스크랩 인덱스',
  manageremail         VARCHAR     NOT NULL COMMENT '담당자 이메일',
  useremail            VARCHAR(20) NOT NULL COMMENT '유저 이메일'
) COMMENT '기업 스크랩';

CREATE TABLE companyreview
(
  companyreviewindex INT         NOT NULL COMMENT '기업리뷰인덱스',
  useremail          VARCHAR(20) NOT NULL COMMENT '유저 이메일',
  manageremail       VARCHAR     NOT NULL COMMENT '담당자 이메일',
  advancement        INT         NOT NULL DEFAULT 3 COMMENT '승진기회',
  benefit            INT         NOT NULL DEFAULT 3 COMMENT '복지및급여',
  worklife           INT         NOT NULL DEFAULT 3 COMMENT '워라벨',
  companycurture     INT         NOT NULL DEFAULT 3 COMMENT '사내문화',
  management         INT         NOT NULL DEFAULT 3 COMMENT '경영진',
  content            TEXT        NULL     COMMENT '기업리뷰내용',
  companyreviewtitle VARCHAR(30) NOT NULL COMMENT '기업리뷰타이틀',
  companyreviewdate  VARCHAR(30) NOT NULL COMMENT '기업리뷰작성날짜'
) COMMENT '가업리뷰';

CREATE TABLE CV
(
  index     INT          NOT NULL COMMENT '인덱스번호',
  CVimage   VARCHAR      NOT NULL COMMENT '프로필이미지',
  mainCV    BOOLEAN      NULL     DEFAULT false COMMENT '메인이력서 구분',
  education VARCHAR(30)  NOT NULL COMMENT '학력',
  userId    VARCHAR(8)   NOT NULL COMMENT '유저 아이디',
  skill     VARCHAR(500) NULL     COMMENT '기술스택',
  useremail VARCHAR(20)  NOT NULL COMMENT '유저 이메일',
  PRIMARY KEY (index)
) COMMENT '이력서';

CREATE TABLE CVopen
(
  CVopenindex  INT     NOT NULL COMMENT '이력서열람인덱스',
  index        INT     NOT NULL COMMENT '인덱스번호',
  manageremail VARCHAR NOT NULL COMMENT '담당자 이메일',
  PRIMARY KEY (CVopenindex)
) COMMENT '이력서열람';

CREATE TABLE CVportfolio
(
  index         INT NOT NULL COMMENT '인덱스번호',
  CVindex       INT NOT NULL COMMENT '이력서번호',
  potfolioindex INT NULL     COMMENT '인덱스번호',
  PRIMARY KEY (index)
) COMMENT '이력서포트폴리오';

CREATE TABLE github
(
  gitindex       INT          NOT NULL COMMENT '인덱스번호',
  potfolioindex  INT          NOT NULL COMMENT '포트폴리오 인덱스번호',
  repositoryname VARCHAR(200) NOT NULL COMMENT '레파지토리이름',
  repositoryurl  VARCHAR(200) NULL     COMMENT '레파지토리url',
  PRIMARY KEY (gitindex)
) COMMENT '깃허브';

CREATE TABLE interviewreview
(
  interviewreviewindex   INT         NOT NULL COMMENT '면접리뷰인덱스',
  manageremail           VARCHAR     NOT NULL COMMENT '담당자 이메일',
  useremail              VARCHAR(20) NOT NULL COMMENT '유저 이메일',
  ambience               INT         NOT NULL DEFAULT 3 COMMENT '면접분위기',
  difficulty             INT         NOT NULL DEFAULT 3 COMMENT '질문난이도',
  interviewreviewtitle   VARCHAR(30) NOT NULL COMMENT '면접리뷰 제목',
  interviewreviewdate    VARCHAR(30) NOT NULL COMMENT '면접리뷰 작성 날짜',
  interviewreviewcontent VARCHAR(30) NULL     COMMENT '면럽리뷰 내용'
) COMMENT '면접리뷰';

CREATE TABLE letter
(
  index         INT         NOT NULL COMMENT '인덱스',
  userId        VARCHAR(8)  NOT NULL COMMENT '유저 아이디',
  lettertype    VARCHAR(10) NOT NULL COMMENT '자소서타입',
  lettertitle   VARCHAR     NOT NULL COMMENT '자소서제목',
  lettercontent TEXT        NULL     COMMENT '자소서내용',
  useremail     VARCHAR(20) NOT NULL COMMENT '유저 이메일',
  PRIMARY KEY (index)
) COMMENT '자소서';

CREATE TABLE portfolio
(
  index         INT         NOT NULL COMMENT '인덱스번호',
  userId        VARCHAR(8)  NOT NULL COMMENT '유저 아이디',
  portfoliotype VARCHAR(10) NOT NULL COMMENT '포트폴리오 타입',
  url           VARCHAR(60) NOT NULL COMMENT '경로 or 파일',
  useremail     VARCHAR(20) NOT NULL COMMENT '유저 이메일',
  PRIMARY KEY (index)
) COMMENT '포트폴리오';

CREATE TABLE receipt
(
  recepitindex       INT         NOT NULL COMMENT '구매내역인덱스',
  advertisementindex INT         NOT NULL COMMENT '광고인덱스',
  price              INT         NOT NULL COMMENT '가격',
  paymentdate        VARCHAR(50) NOT NULL COMMENT '결제일',
  paymentmethod      VARCHAR(50) NOT NULL COMMENT '결제방법',
  paystatement       VARCHAR(50) NOT NULL COMMENT '결제상태',
  PRIMARY KEY (recepitindex)
) COMMENT '구매내역 ( 기업 )';

CREATE TABLE recruitment
(
  index            INT         NOT NULL COMMENT '인덱스',
  manageremail     VARCHAR     NOT NULL COMMENT '담당자 이메일',
  recruitmenttype  VARCHAR(30) NOT NULL COMMENT '채용형태',
  category         VARCHAR(30) NOT NULL COMMENT '직군',
  skill            VARCHAR(30) NULL     COMMENT '기술스택',
  startdate        VARCHAR(50) NOT NULL COMMENT '시작날짜',
  period           VARCHAR(30) NOT NULL COMMENT '기간',
  status           VARCHAR(10) NOT NULL COMMENT '상태값(마감여부)',
  recruitmentclass VARCHAR(30) NOT NULL COMMENT '광고등급',
  PRIMARY KEY (index)
) COMMENT '공고';

CREATE TABLE recruitmentbookmark
(
  bookmarkindex INT         NOT NULL COMMENT '공고 스크랩인덱스',
  index         INT         NOT NULL COMMENT '인덱스',
  useremail     VARCHAR(20) NOT NULL COMMENT '유저 이메일'
) COMMENT '공고 스크랩';

CREATE TABLE salary
(
  index         INT     NOT NULL COMMENT '인덱스번호',
  position      VARCHAR NOT NULL COMMENT '직급',
  averagesalary INT     NOT NULL COMMENT '평균연봉',
  minsalary     INT     NOT NULL COMMENT '최소연봉',
  maxsalary     INT     NOT NULL COMMENT '최대연봉',
  index         INT     NOT NULL COMMENT '인덱스번호',
  PRIMARY KEY (index)
) COMMENT '연봉';

CREATE TABLE user
(
  useremail       VARCHAR(20) NOT NULL COMMENT '유저 이메일',
  userpassword    VARCHAR(20) NOT NULL COMMENT '유저 비밀번호',
  username        VARCHAR(10) NOT NULL COMMENT '유저 이름',
  useradress      VARCHAR(30) NOT NULL COMMENT '유저 주소',
  userphonenumber VARCHAR(11) NOT NULL COMMENT '유저 핸드폰',
  userbrithday    VARCHAR(8)  NOT NULL COMMENT '유저 생년월일',
  freelancer      BOOLEAN     NULL     DEFAULT false COMMENT '프리랜서 구분',
  PRIMARY KEY (useremail)
) COMMENT '유저';

CREATE TABLE usermembership
(
  usermembershipindex INT         NULL     COMMENT '유저맴버쉽인덱스',
  useremail           VARCHAR(20) NOT NULL COMMENT '유저 이메일',
  startdate           VARCHAR(30) NOT NULL COMMENT '맴버쉬시작날짜',
  period              VARCHAR(30) NOT NULL COMMENT '기간'
) COMMENT '유저맴버쉽';

ALTER TABLE category
  ADD CONSTRAINT FK_company_TO_category
    FOREIGN KEY (manageremail)
    REFERENCES company (manageremail);

ALTER TABLE salary
  ADD CONSTRAINT FK_category_TO_salary
    FOREIGN KEY (index)
    REFERENCES category (index);

ALTER TABLE CVportfolio
  ADD CONSTRAINT FK_CV_TO_CVportfolio
    FOREIGN KEY (CVindex)
    REFERENCES CV (index);

ALTER TABLE github
  ADD CONSTRAINT FK_portfolio_TO_github
    FOREIGN KEY (potfolioindex)
    REFERENCES portfolio (index);

ALTER TABLE CVportfolio
  ADD CONSTRAINT FK_portfolio_TO_CVportfolio
    FOREIGN KEY (potfolioindex)
    REFERENCES portfolio (index);

ALTER TABLE recruitment
  ADD CONSTRAINT FK_company_TO_recruitment
    FOREIGN KEY (manageremail)
    REFERENCES company (manageremail);

ALTER TABLE CV
  ADD CONSTRAINT FK_user_TO_CV
    FOREIGN KEY (useremail)
    REFERENCES user (useremail);

ALTER TABLE portfolio
  ADD CONSTRAINT FK_user_TO_portfolio
    FOREIGN KEY (useremail)
    REFERENCES user (useremail);

ALTER TABLE career
  ADD CONSTRAINT FK_user_TO_career
    FOREIGN KEY (useremail)
    REFERENCES user (useremail);

ALTER TABLE letter
  ADD CONSTRAINT FK_user_TO_letter
    FOREIGN KEY (useremail)
    REFERENCES user (useremail);

ALTER TABLE applyCV
  ADD CONSTRAINT FK_CV_TO_applyCV
    FOREIGN KEY (index)
    REFERENCES CV (index);

ALTER TABLE applyCV
  ADD CONSTRAINT FK_recruitment_TO_applyCV
    FOREIGN KEY (index)
    REFERENCES recruitment (index);

ALTER TABLE recruitmentbookmark
  ADD CONSTRAINT FK_recruitment_TO_recruitmentbookmark
    FOREIGN KEY (index)
    REFERENCES recruitment (index);

ALTER TABLE recruitmentbookmark
  ADD CONSTRAINT FK_user_TO_recruitmentbookmark
    FOREIGN KEY (useremail)
    REFERENCES user (useremail);

ALTER TABLE companybookmark
  ADD CONSTRAINT FK_company_TO_companybookmark
    FOREIGN KEY (manageremail)
    REFERENCES company (manageremail);

ALTER TABLE companybookmark
  ADD CONSTRAINT FK_user_TO_companybookmark
    FOREIGN KEY (useremail)
    REFERENCES user (useremail);

ALTER TABLE companyreview
  ADD CONSTRAINT FK_company_TO_companyreview
    FOREIGN KEY (manageremail)
    REFERENCES company (manageremail);

ALTER TABLE companyreview
  ADD CONSTRAINT FK_user_TO_companyreview
    FOREIGN KEY (useremail)
    REFERENCES user (useremail);

ALTER TABLE interviewreview
  ADD CONSTRAINT FK_company_TO_interviewreview
    FOREIGN KEY (manageremail)
    REFERENCES company (manageremail);

ALTER TABLE interviewreview
  ADD CONSTRAINT FK_user_TO_interviewreview
    FOREIGN KEY (useremail)
    REFERENCES user (useremail);

ALTER TABLE advertisement
  ADD CONSTRAINT FK_recruitment_TO_advertisement
    FOREIGN KEY (index)
    REFERENCES recruitment (index);

ALTER TABLE CVopen
  ADD CONSTRAINT FK_CV_TO_CVopen
    FOREIGN KEY (index)
    REFERENCES CV (index);

ALTER TABLE CVopen
  ADD CONSTRAINT FK_company_TO_CVopen
    FOREIGN KEY (manageremail)
    REFERENCES company (manageremail);

ALTER TABLE usermembership
  ADD CONSTRAINT FK_user_TO_usermembership
    FOREIGN KEY (useremail)
    REFERENCES user (useremail);

ALTER TABLE receipt
  ADD CONSTRAINT FK_advertisement_TO_receipt
    FOREIGN KEY (advertisementindex)
    REFERENCES advertisement (advertisementindex);

        
      