const PROXY_CONFIG = [
  {
    context: [
      "/api/v1/me",
      "/auth/login",
      "/auth/logout"
    ],
    target: "http://localhost:8080",
    secure: false
  }
];

module.exports = PROXY_CONFIG;
