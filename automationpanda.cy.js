describe("Assertions demo", ()=>{
    before(() => {
        // Run this hook before all tests
        cy.visit("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/");
      });
    it("implicit assertions",()=>{
        //cy.visit("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/")
        // should and
        //checking url
        cy.url().should('include','automationpanda.com')
        .should('eq','https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/')
        .should('contain','automationpanda')
        //checking title
        cy.title().should('include','Automation Panda')
        .and('eq','Want to practice test automation? Try these demo sites! | Automation Panda')
        //click speaking
        cy.get('#menu-item-10593 > a').click()
        //checking title in speaking page
        cy.title().should('include','Speaking | Automation Panda')

        cy.get('.entry-content > :nth-child(2)')
        cy.get('.entry-content > :nth-child(2)').invoke('text').as('textFunction')

    })

})

