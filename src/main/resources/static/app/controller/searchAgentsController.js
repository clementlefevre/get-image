gettyApp.controller('searchAgentsController', function ($rootScope, $scope, $http) {
    console.log("searchAgentsController reporting for duty.");


     $scope.searchImages = function () {

            new_search_agent = $scope.new_search_agent;
            console.log(new_search_agent);


            $http.post('images/search', new_search_agent).success(function (data) {

                $scope.imagesList = data;
                console.log($scope.imagesList);

            }).error(function (data, status) {

                alert("Search error. Please try again or contact administrator.");
                return status;
            });


        };


        $scope.showDetails = function(image){
        if(image.showDetails == true){
        image.showDetails= false;} else{
        image.showDetails = true;
        }

        };



    $scope.new_search_agent = {
        'keywords': ''
        };

    $scope.imagesList=[];




    $scope.sort = {
        column: 'name',
        descending: false
    };

    $scope.changeSorting = function (column) {

        var sort = $scope.sort;

        if (sort.column == column) {
            sort.descending = !sort.descending;
        } else {
            sort.column = column;
            sort.descending = false;
        }
    };





});
