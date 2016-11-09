angular.module('twitterApp', []).controller(
        'home',
        function ($http) {
            var self = this, username = "emmanueljreyme";

            init();

            function init() {
                userInfo();
                userTweets();
            }

            function userInfo() {
                $http.get('/users/' + username).then(function (response) {
                    self.user = response.data;
                })
            }

            function userTweets() {
                $http.get('/users/' + username + "/tweets").then(
                        function (response) {
                            self.tweets = response.data;
                        })
            }

        });