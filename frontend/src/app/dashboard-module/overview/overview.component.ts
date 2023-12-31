import { Component, OnInit } from '@angular/core';
import { Chart } from 'chart.js';

@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.css']
})
export class OverviewComponent implements OnInit {
  
  ngOnInit(): void {

      // Monthly sales chart
      var myChart = new Chart("myChart1", {
        type: 'bar',
        data: {
            labels: ['Puma', 'Converse', 'Nike', 'Adidas', 'Vans', 'Reebok'],
            datasets: [{
                label: 'Info',
                data: [12, 15, 3, 5, 2, 3],
                backgroundColor: [
                    'black',
                    'yellow',
                    'green',
                    'pink',
                    'blue',
                    'orange'
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            maintainAspectRatio: false,
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });


      // Radar chart
      var myChart = new Chart("myChart2", {
        type: 'doughnut',
        data: {
            labels: ['Black', 'White', 'Red', 'Grey'],
            datasets: [{
                label: 'Info',
                data: [12, 50, 3, 5, 2, 3],
                backgroundColor: [
                    'black',
                    'white',
                    'red',
                    'grey'
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)'
                ],
                borderWidth: 1
            }]
        },
        // options: {
        //     scales: {
        //         yAxes: [{
        //             ticks: {
        //                 beginAtZero: true
        //             }
        //         }]
        //     }
        // }
    });
    
    var myChart = new Chart("myChart3", {
      type: 'line',
      data: {
          labels: ['January', 'February', 'March', 'April', 'June', 'July'],
          datasets: [{
              label: 'Info',
              data: [12, 15, 3, 5, 2, 3],
              backgroundColor: [
                  'green',
                  'yellow',
                  'rgba(255, 206, 86, 0.2)',
                  'rgba(75, 192, 192, 0.2)',
                  'rgba(153, 102, 255, 0.2)',
                  'rgba(255, 159, 64, 0.2)'
              ],
              borderColor: [
                  'rgba(255, 99, 132, 1)',
                  'rgba(54, 162, 235, 1)',
                  'rgba(255, 206, 86, 1)',
                  'rgba(75, 192, 192, 1)',
                  'rgba(153, 102, 255, 1)',
                  'rgba(255, 159, 64, 1)'
              ],
              borderWidth: 1
          }]
      },
      options: {
        maintainAspectRatio: false,
        aspectRatio: 1,
          scales: {
              yAxes: [{
                  ticks: {
                      beginAtZero: true
                  }
              }]
          }
      }
    });
  
}
}