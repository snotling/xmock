import { Component, OnInit } from '@angular/core';
import {ServerFile} from "../../bean/server.file";

@Component({
  selector: 'app-file-browser',
  templateUrl: './file-browser.component.html',
  styleUrls: ['./file-browser.component.css']
})
export class FileBrowserComponent implements OnInit {

  files:Array<ServerFile>;

  constructor() {
    this.files = new Array();

  }

  ngOnInit() {
    this.files.push(new ServerFile("test.txt", "/opt/gma", false, false));
    this.files.push(new ServerFile("plop.txt", "/opt/gma", false, false));
  }

}
