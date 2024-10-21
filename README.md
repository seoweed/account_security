# Account_security
프로젝트 -🚨 Account_security <br><br>


## 💫 프로젝트 소개 ##
사용자의 계정 정보를 안전하게 보관하고, 사용자가 원할 때 계정 정보를 받을 수 있는 계정 보안 웹 프로젝트입니다.<br> 
암호화된 저장 방식과 안전한 인증 절차를 통해 개인정보 보호를 강화합니다. <br>


## 🔥 기획 내용 ##
이 프로젝트는 사용자의 계정을 안전하게 보관하고 관리하는 기능을 중심으로 합니다. 사용자가 등록한 계정을 암호화하여 데이터베이스에 저장하고, 필요 시에는 특정 계정을 선택해 복호화된 상태로 사용자에게 제공하는 방식입니다.

### 주요 기능
**로그인 및 회원가입 구현**
Spring Security와 웹 세션, 쿠키를 통해 사용자 인증과 회원가입 기능을 구현하였습니다. 이를 통해 사용자는 각자의 계정으로 안전하게 로그인할 수 있으며, 세션과 쿠키를 사용하여 사용자를 구분하고 지속적인 로그인 상태를 유지합니다.

**데이터 암·복호화**
사용자의 민감한 계정 정보는 SEED CBC 암호화 알고리즘을 통해 암호화되었습니다. SEED 알고리즘은 안전한 암호화 방식으로, 데이터를 보호하는 데 적합합니다. 복호화는 사용자가 필요한 경우에만 수행되어, 보안이 강화됩니다.

**데이터 저장 및 관리**
암호화된 정보는 MySQL 데이터베이스에 안전하게 저장됩니다. MySQL은 대규모 데이터를 안정적으로 처리할 수 있는 데이터베이스로, 계정 정보의 안전한 보관을 보장합니다.

**안전한 인증 절차**
Spring Security를 통해 사용자 인증 및 권한 관리를 강화하였으며, 사용자의 세션 및 쿠키를 안전하게 처리하여 보안성을 높였습니다. 이를 통해 허가되지 않은 접근을 차단하고, 인증된 사용자만 계정 정보를 복호화할 수 있습니다.

**계정 관리 시스템**
사용자는 자신의 여러 계정을 등록하여 안전하게 보관할 수 있으며, 필요할 때 특정 계정을 복호화하여 사용 가능하게 만들었습니다. 이를 통해 간편한 계정 관리와 개인정보 보호를 동시에 실현할 수 있습니다.

이 프로젝트는 사용자가 다양한 플랫폼에서 사용하는 계정 정보를 한 곳에 안전하게 보관할 수 있도록 하여, 개인정보 보호를 강화하는 데 목적이 있습니다.

## 🕰️ 개발 기간 
* 2023.10 ~ 2023.11

### 🐣 멤버 구성 (1인)
- 서주현

### 📢 개발 환경
- **Java 11**
- **Framework**: Spring Boot
- **Database**: MySQL
- **Security**: Spring Security, SEED CBC Encryption
- **ORM** : JPA

## :busts_in_silhouette: Team Members ##

|                                               서주현                                              |                                       
|:-----------------------------------------------------------------------------------------------:|
| <img src="https://github.com/seoweed.png" width="100" height="100">                             |
|                            [@seoweed](https://github.com/seoweed)                               | 
