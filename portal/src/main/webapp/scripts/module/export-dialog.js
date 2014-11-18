'use strict';

Tc.Module.ExportDialog = Tc.Module.extend({
    on: function(callback) {
        var self = this,
            $ctx = this.$ctx,
            now = new Date(),
            minDate = new Date('2014/06/01'),
            dialog = $ctx.data('dialog');

        var YEAR_LIST = [],
            MONTH_LIST = [
                "1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"
            ];


        function generateYear(minDate,maxDate,YEAR_LIST) {
            for (var i = 0; i < ( maxDate.getFullYear() - minDate.getFullYear() + 1 ); i++) {
                YEAR_LIST.push(minDate.getFullYear() + i);
            }
        }

        generateYear(minDate,now,YEAR_LIST);

        var startDate,
            endDate ;


        function formatDate(year,month) {
            return new Date( year + '/' + month.replace('月', '') + '/01');
        }

        function setEndDate(self) {
            var min = new Date(
                    Math.max(minDate, formatDate(self.startYear(), self.startMonth()))
                ),
                max = new Date(
                    Math.min(now, formatDate(self.startYear() + 1, self.startMonth()))
                );

            var yearList = [];
            generateYear(min, max, yearList);
            viewModel.availableEndYear(yearList);

            if(min.getFullYear() == max.getFullYear()){
                viewModel.availableEndMonth(MONTH_LIST.slice(min.getMonth(), max.getMonth()+1));
            }else{
                if (self.endYear() == min.getFullYear()) {
                    viewModel.availableEndMonth(MONTH_LIST.slice(now.getMonth()));
                } else if (self.endYear() == max.getFullYear()) {
                    viewModel.availableEndMonth(MONTH_LIST.slice(0, now.getMonth() + 1));
                } else {
                    viewModel.availableEndMonth(MONTH_LIST);
                }
            }
        }

        function setStartDate(self) {
            var min = new Date(
                    Math.max(minDate, formatDate(self.endYear() - 1, self.endMonth()))
                ),
                max = new Date(
                    Math.min(now, formatDate(self.endYear(), self.endMonth()))
                );

            var yearList = [];
            generateYear(min, max, yearList);
            viewModel.availableStartYear(yearList);

            if(min.getFullYear() == max.getFullYear()){
                viewModel.availableStartMonth(MONTH_LIST.slice(min.getMonth(), max.getMonth()+1));
            }else{
                if (self.startYear() == min.getFullYear()) {
                    viewModel.availableStartMonth(MONTH_LIST.slice(now.getMonth()));
                } else if (self.startYear() == max.getFullYear()) {
                    viewModel.availableStartMonth(MONTH_LIST.slice(0, now.getMonth() + 1));
                } else {
                    viewModel.availableEndMonth(MONTH_LIST);
                }
            }
        }

        var viewModel = {

            availableStartYear : ko.observableArray(),
            availableStartMonth : ko.observableArray(),

            startYear : ko.observable(),
            startMonth : ko.observable(),

            availableEndYear : ko.observableArray(),
            availableEndMonth : ko.observableArray(),

            endYear : ko.observable(),
            endMonth : ko.observable(),

            exportUrl : ko.observable(),

            selectStartChange : function(){

                var self = this;

                window.setTimeout(function(){

                    setStartDate(self);
                    setEndDate(self);

                    var endDate = formatDate(self.endYear(), self.endMonth());
                    self.exportUrl("orders/export.do?from=" +  formatDate(self.startYear(), self.startMonth()).getTime() +
                        "&to=" + (endDate.setMonth(endDate.getMonth() + 1) - 1000));
                },10);

            },
            selectEndChange : function(){

                var self = this;

                window.setTimeout(function(){

                    setEndDate(self);
                    setStartDate(self);

                    var endDate = formatDate(self.endYear(), self.endMonth());
                    self.exportUrl("orders/export.do?from=" +  formatDate(self.startYear(), self.startMonth()).getTime() +
                        "&to=" + (endDate.setMonth(endDate.getMonth() + 1) - 1000));
                },10);

            }
        };


        function initEndDate(){
            viewModel.availableEndYear(YEAR_LIST);
            viewModel.availableEndMonth(MONTH_LIST.slice(0,now.getMonth()+1));
            viewModel.endYear(now.getFullYear());
            viewModel.endMonth(MONTH_LIST[now.getMonth()]);
        }

        var init = function(){

            viewModel.availableStartYear(YEAR_LIST);
            viewModel.availableStartMonth(MONTH_LIST);

            initEndDate();

            ko.applyBindings(viewModel,$ctx[0]);
        };

        init();


        callback();
    }
});


