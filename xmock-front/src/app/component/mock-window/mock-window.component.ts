import { Component } from '@angular/core';
import {Scenario} from "../../bean/scenario";
import {Type} from "../../enum/type.enum";

@Component({
  selector: 'app-mock-window',
  templateUrl: './mock-window.component.html',
  styleUrls: ['./mock-window.component.css']
})
export class MockWindowComponent {

  powers = ['Really Smart', 'Super Flexible',
    'Super Hot', 'Weather Changer'];

  model = new Scenario(18, 'Dr IQ', null, Type.jms);

  submitted = false;

  onSubmit() { this.submitted = true; }

  newScenario() {
    this.model = new Scenario(18, 'Dr IQ', null, Type.jms);
  }

}
