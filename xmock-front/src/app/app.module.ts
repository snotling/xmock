import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MockWindowComponent } from './component/mock-window/mock-window.component';
import { FormsModule }   from '@angular/forms';
import { FileBrowserComponent } from './component/file-browser/file-browser.component';

@NgModule({
  declarations: [
    AppComponent,
    MockWindowComponent,
    FileBrowserComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
